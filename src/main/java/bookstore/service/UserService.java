package bookstore.service;

import bookstore.model.User;

import java.util.List;

public interface UserService {
    public User createUser(User user);
    public String updateUser(User user);
    public String deleteUser(String userId);
    public User getUser(Long userId);
    public List<User> getAllUsers();
    public List<User> getById(String userId);

}
