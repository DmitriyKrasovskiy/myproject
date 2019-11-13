package by.pvt.user;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import by.pvt.pojo.Role;
import by.pvt.pojo.RoleName;
import by.pvt.pojo.User;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Set;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    RoleRepository roleRepository;

    @Transactional
    public boolean saveNewUser(User user, RoleName roleName) {
        if (user == null || user.getName().isEmpty() || user.getUsername().isEmpty() ||
                user.getEmail().isEmpty() || user.getPassword().isEmpty()) {
            return false;
        }

        Integer userCountByLogin = userRepository.findUserCountByLogin(user.getUsername());
        if (userCountByLogin!=null&&userCountByLogin >= 1) {
            return false;
        }

        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);

        Role role = roleRepository.findRoleByName(roleName);
        if (role == null) {
            role = new Role();
            role.setRoleName(roleName);
        }

        user.setRoles(Set.of(role));
        userRepository.save(user);
        return true;
    }
    @Transactional
    public List<String> getAllRoles(){
        return roleRepository.getRoleNames();
}

}
