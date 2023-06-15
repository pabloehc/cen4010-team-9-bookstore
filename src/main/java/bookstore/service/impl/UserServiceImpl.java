package bookstore.service.impl;

import bookstore.repository.UserRepository;
import bookstore.model.User;
import bookstore.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImpl implements UserService {
    UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public String updateUser(User user) {
        return null;
    }

    @Override
    public String deleteUser(String userId) {
        return null;
    }

    @Override
    public User getUser(Long userId) {
       return userRepository.findById(userId).get();
    }

    @Override
    public List<User> getAllUsers() {
        return null;
    }

    @Override
    public List<User> getById(String userId) {
        return null;
    }
}
