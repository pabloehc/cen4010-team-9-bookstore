package com.Group9.Shoppingcart.service;

import com.Group9.Shoppingcart.model.Book;

import java.util.List;

public interface BookService {
    Book getBookById(Long id);
    List<Book> getAllBooks();

}
