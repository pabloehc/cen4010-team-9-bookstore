package com.Group9.Shoppingcart.service.impl;

import com.Group9.Shoppingcart.model.User;
import com.Group9.Shoppingcart.repository.UserRepository;
import com.Group9.Shoppingcart.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImpl implements UserService {
    UserRepository userRepository;
    @Override
    public User getUserById(Long id) {
        return userRepository.findById(id).get();
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.getAllUsers();
    }
}
