package com.Group9.Shoppingcart.service;

import com.Group9.Shoppingcart.model.User;

import java.util.List;

public interface UserService {
    public String createUser(User user);
    public String updateUser(User user);
    public String deleteUser(String userId);
    public User getUser(String userId);
    public List<User> getAllUsers();
    public List<User> getById(String userId);

}
