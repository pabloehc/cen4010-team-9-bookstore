package com.Group9.Shoppingcart.service.impl;

import com.Group9.Shoppingcart.model.User;
import com.Group9.Shoppingcart.repository.UserRepository;
import com.Group9.Shoppingcart.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImpl implements UserService {
    UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public String createUser(User user) {
        return null;
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
    public User getUser(String userId) {
        return null;
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
