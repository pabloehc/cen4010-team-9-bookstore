package com.Group9.Shoppingcart.controller;

import com.Group9.Shoppingcart.model.Book;
import com.Group9.Shoppingcart.model.User;
import com.Group9.Shoppingcart.service.BookService;
import com.Group9.Shoppingcart.service.ShoppingCartService;
import com.Group9.Shoppingcart.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cart")
public class ShoppingCartController {

        private final ShoppingCartService shoppingCartService;
        private final BookService bookService;
        private final UserService userService;

    @Autowired
    public ShoppingCartController(ShoppingCartService shoppingCartService, BookService bookService, UserService userService) {
        this.shoppingCartService = shoppingCartService;
        this.bookService = bookService;
        this.userService = userService;
    }

    @PostMapping("/addBookToCart")
    public ResponseEntity<String> addBookToCart(@RequestBody Book book) {
        bookService.getAllCBooks().add(book);
        return ResponseEntity.ok(bookService.createBook(book));
    }






 }



