package com.Group9.Shoppingcart.service;

import com.Group9.Shoppingcart.model.Book;
import com.Group9.Shoppingcart.model.ShoppingCart;
import com.Group9.Shoppingcart.model.User;

import java.util.List;

public interface ShoppingCartService {
    public String createShoppingCart(ShoppingCart cart);
    public String updateShoppingCart(ShoppingCart cart);
    public String deleteShoppingCart(String cartId);
    public ShoppingCart getShoppingCart(String cartId);
    public List<ShoppingCart> getAllShoppingCart();
    public List<ShoppingCart> getById(String cartId);
}
