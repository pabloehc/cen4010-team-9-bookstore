package com.Group9.Shoppingcart.service.impl;

import com.Group9.Shoppingcart.model.Book;
import com.Group9.Shoppingcart.repository.BookRepository;
import com.Group9.Shoppingcart.service.BookService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BookServiceImpl implements BookService {
    BookRepository bookRepository;
    @Override
    public Book getBookById(Long id) {
        return bookRepository.findById(id).get();
    }

    @Override
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }
}
