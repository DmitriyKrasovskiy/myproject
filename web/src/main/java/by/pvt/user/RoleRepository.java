package by.pvt.user;


import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import by.pvt.pojo.Role;
import by.pvt.pojo.RoleName;

import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;


@Repository
public class RoleRepository {

    private static Logger log =Logger.getLogger("RoleRepository");

    @Autowired
    SessionFactory sessionFactory;

    public Role findRoleByName(RoleName roleName){

        try {
            return sessionFactory.getCurrentSession()
                    .createQuery("from Role where roleName like :param1", Role.class)
                    .setParameter("param1",roleName)
                    .getSingleResult();
        } catch (Exception e) {
            log.warning(e.getMessage());
            return null;
        }

    }

    public List<String> getRoleNames(){
        return sessionFactory.getCurrentSession()
                .createQuery("select roleName from Role", RoleName.class)
                .list()
                .stream()
                .map(Enum::name)
                .collect(Collectors.toList());
    }
}
