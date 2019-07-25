package coder.impls;

import coder.daos.UserDao;
import coder.models.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class UserImpl implements UserDao {
    @Autowired
    private SessionFactory sessionFactory;

    private Session session() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public List<User> getAllUser() {
        Query query = session().createQuery("from User");
        List<User> users = query.list();
        session().flush();
        return users;
    }

    @Override
    public User getUserById(int id) {
        User user = session().get(User.class, id);
        session().flush();
        return user;
    }

    @Override
    public User getUserByUserName(String username) {
        Query query = session().createQuery("from User where username=:username");
        query.setParameter("username", username);
        User user = (User) query.uniqueResult();
        session().flush();
        return user;
    }

    @Override
    public void updateUser(User user) {
        session().saveOrUpdate(user);
        session().flush();
    }

    @Override
    public void deleteUserById(int id) {
        session().delete(getUserById(id));
        session().flush();
    }

    @Override
    public void createUser(User user) {
        session().save(user);
        session().flush();
    }
}
