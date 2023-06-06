package com.Group9.Shoppingcart.repository;
import com.Group9.Shoppingcart.model.CartItem;
import com.Group9.Shoppingcart.model.ShoppingCart;
import com.Group9.Shoppingcart.model.User;
import org.hibernate.annotations.Cascade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface ShoppingCartRepository extends JpaRepository<ShoppingCart, Long> {
  @Query("SELECT s FROM ShoppingCart s")
   ShoppingCart getShoppingCartByCartItems(Set<CartItem> cartItems);
}

