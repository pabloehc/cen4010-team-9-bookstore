package com.Group9.Shoppingcart.service;

import com.Group9.Shoppingcart.model.User;

import java.util.List;

public interface UserService {
    User getUserById(Long id);
    List<User> getAllUsers();
}
