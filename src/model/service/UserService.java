package model.service;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();
    int createUser(User user);
    int deleteUserById(int id);
    int updateUserById(int id, User user);
}
