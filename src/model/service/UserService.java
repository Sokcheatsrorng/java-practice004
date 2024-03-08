package model.service;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();
    User searchByID(Integer id);
    int createUser(User user);
    int deleteUserById(int id);
    int updateUserById(int id, User user);
}
