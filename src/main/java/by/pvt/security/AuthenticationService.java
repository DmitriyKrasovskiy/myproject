package by.pvt.security;



import by.pvt.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import by.pvt.pojo.User;

import javax.transaction.Transactional;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@Service("authService")
public class AuthenticationService implements UserDetailsService {

    private static Logger log = Logger.getLogger("AuthenticationService");

    @Autowired
    UserRepository userRepository;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        log.info("loadUserByUserName() username="+username);
        User user =userRepository.findUserByLogin(username);

        if (user==null){
            throw new UsernameNotFoundException("Username "+username+" not found");
        }

        return new org.springframework.security.core.userdetails.User(
                user.getUsername(),
                user.getPassword(),
                user.getRoles().stream()
                .map(role -> new SimpleGrantedAuthority("ROLE_"+role.getRoleName().name()))
                .collect(Collectors.toList()));
    }
}
