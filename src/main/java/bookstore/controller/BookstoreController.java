package bookstore.controller;

import bookstore.model.Book;
import bookstore.service.BookService;
import bookstore.service.ShoppingCartService;
import bookstore.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/bookstore")
public class BookstoreController {

    private final ShoppingCartService shoppingCartService;
    private final BookService bookService;
    private final UserService userService;

    @Autowired
    public BookstoreController(ShoppingCartService shoppingCartService, BookService bookService, UserService userService) {
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
