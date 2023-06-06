package com.Group9.Shoppingcart.repository;

import com.Group9.Shoppingcart.model.Book;
import com.Group9.Shoppingcart.model.CartItem;
import com.Group9.Shoppingcart.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CartItemRepository extends JpaRepository<CartItem, Long> {
    @Query("SELECT u FROM User u")
    Double calculateTotalPriceByUser(@Param("user") String user);
    void deleteByBookAndUser(Book book, User user);
    List<CartItem> findAllByUser(User user);
    void findByBookIdAndUserId(Long bookId, Long userId);
}
