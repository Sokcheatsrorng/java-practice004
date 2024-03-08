package model.service;

import repository.UserRepository;

import java.util.List;

public class UserServiceImpl implements UserService {
    private static final UserRepository repository = new UserRepository();
    @Override
    public List<User> getAllUsers() {
        return repository.getAllUsers();
    }
    @Override
    public int createUser(User user) {
        return repository.createUser(user);
    }
    @Override
    public int deleteUserById(int id) {
        return repository.deleteUserById(id);
    }
    @Override
    public int updateUserById(int id, User user) {
        return repository.updateUserById(id,user);
    }

}
