package coder.daos;

import coder.models.User;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface UserDao {
    List<User> getAllUser();
    User getUserById(int id);
    User getUserByUserName(String username);
    void updateUser(User user);
    void deleteUserById(int id);
    void createUser(User user);
}
