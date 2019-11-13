package by.pvt.user;


import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import by.pvt.pojo.User;

import java.util.logging.Logger;

@Repository
public class UserRepository {

    private static Logger log = Logger.getLogger("UserRepository");

    @Autowired
    SessionFactory sessionFactory;

    public Integer findUserCountByLogin(String userName){
        return sessionFactory
                .getCurrentSession()
                .createQuery("from User where username like :param1", User.class)
                .setParameter("param1", userName)
                .list()
                .size();
    }

    public void save (User user){
        sessionFactory
                .getCurrentSession()
                .persist(user);
    }

    public User findUserByLogin(String username){
        try {
            return sessionFactory
                    .getCurrentSession()
                    .createQuery("from User where username like :param1", User.class)
                    .setParameter("param1",username)
                    .getSingleResult();
        } catch (Exception e) {
            log.warning(e.getMessage());
            return null;
        }
    }
}
