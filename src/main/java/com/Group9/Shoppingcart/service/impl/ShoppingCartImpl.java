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
    public double getUserCartTotalPrice(User userId) {
       return 0;
    }
    @Override
    public void addBookToCart(User userId, Book bookId) {


    }

    @Override
    public List<Book> getAllUserBookInCart(String userId) {
        return null;
    }

    @Override
    public void deleteBookFromUserCart(String userId, String bookId) {

    }
}
