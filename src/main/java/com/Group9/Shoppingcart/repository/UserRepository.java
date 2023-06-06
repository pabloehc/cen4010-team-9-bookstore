package com.Group9.Shoppingcart.repository;

import com.Group9.Shoppingcart.model.CartItem;
import com.Group9.Shoppingcart.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {

    @Query("SELECT u FROM User u")
    List<User> getAllUsers();

    void getById(User id);
}
