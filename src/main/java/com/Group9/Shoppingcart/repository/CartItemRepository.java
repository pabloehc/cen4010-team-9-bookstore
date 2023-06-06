package com.Group9.Shoppingcart.repository;

import com.Group9.Shoppingcart.model.Book;
import com.Group9.Shoppingcart.model.CartItem;
import com.Group9.Shoppingcart.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CartItemRepository extends JpaRepository<CartItem, Long> {
    List<CartItem> findAllByUser(User user);
    List<CartItem> findAllByUserAndBook(User user, Book book);
    List<CartItem> findAllById(Long id);

}
