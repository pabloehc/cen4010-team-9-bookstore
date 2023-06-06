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


    @GetMapping("/total-price{userId}")
        public double getTotalPriceByUserId(@PathVariable("userId") User userId) {
          return shoppingCartService.getUserCartTotalPrice(userId);
        }
    @PostMapping("/add-book/{userId}/{bookId}")
    public ResponseEntity<String> addBookToCart(@PathVariable("userId") Long userId, @PathVariable("bookId") Long bookId) {

        User user = userService.getUserById(userId);
        Book book = bookService.getBookById(bookId);
        if (user == null || book == null) {
            return ResponseEntity.notFound().build();
        }

        shoppingCartService.addBookToCart(user, book);
        return ResponseEntity.ok("Book added to cart successfully.");
    }


 }



