package coder.services;

import coder.daos.AuthDao;
import coder.daos.UserDao;
import coder.models.Authority;
import coder.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserDao userDao;

    @Autowired
    private AuthDao authDao;

    public void addAuth(Authority auth) {
        authDao.addAuth(auth);
    }

    public List<User> getAllUser() {
        return userDao.getAllUser();
    }

    public User getUserById(int id) {
        return userDao.getUserById(id);
    }

    public User getUserByUserName(String username) {
        return userDao.getUserByUserName(username);
    }

    public void updateUser(User user) {
        userDao.updateUser(user);
    }

    public void deleteUserById(int id) {
        userDao.deleteUserById(id);
    }

    public void createUser(User user) {
        userDao.createUser(user);
    }
}
