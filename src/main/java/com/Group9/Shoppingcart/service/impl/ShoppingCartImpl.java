package com.Group9.Shoppingcart.service.impl;

import com.Group9.Shoppingcart.model.Book;
import com.Group9.Shoppingcart.model.CartItem;
import com.Group9.Shoppingcart.model.ShoppingCart;
import com.Group9.Shoppingcart.model.User;
import com.Group9.Shoppingcart.repository.ShoppingCartRepository;
import com.Group9.Shoppingcart.service.ShoppingCartService;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class ShoppingCartImpl implements ShoppingCartService {
    ShoppingCartRepository repository;

    public ShoppingCartImpl(ShoppingCartRepository repository) {
        this.repository = repository;
    }
    @Override
    public String createShoppingCart(ShoppingCart cart) {
        return null;
    }

    @Override
    public String updateShoppingCart(ShoppingCart cart) {
        return null;
    }

    @Override
    public String deleteShoppingCart(String cartId) {
        return null;
    }

    @Override
    public ShoppingCart getShoppingCart(String cartId) {
        return null;
    }

    @Override
    public List<ShoppingCart> getAllShoppingCart() {
        return null;
    }

    @Override
    public List<ShoppingCart> getById(String cartId) {
        return null;
    }
}

