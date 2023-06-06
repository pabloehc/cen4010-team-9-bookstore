package com.Group9.Shoppingcart.service;

import com.Group9.Shoppingcart.model.Book;
import com.Group9.Shoppingcart.model.User;

import java.util.List;

public interface ShoppingCartService {
    public double getUserCartTotalPrice(User userId);
    public void addBookToCart(User userId, Book bookId);
    public List<Book> getAllUserBookInCart(String userId);
    public void deleteBookFromUserCart(String userId, String bookId);
}
