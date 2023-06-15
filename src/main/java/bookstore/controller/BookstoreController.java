package bookstore.controller;

import bookstore.model.Book;
import bookstore.model.ShoppingCart;
import bookstore.model.User;
import bookstore.service.BookService;
import bookstore.service.ShoppingCartService;
import bookstore.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/bookstore")
public class BookstoreController {

    private final BookService bookService;
    private final UserService userService;
    private final ShoppingCartService shoppingCartService;

    @Autowired
    public BookstoreController(BookService bookService, UserService userService, ShoppingCartService shoppingCartService) {
        this.bookService = bookService;
        this.userService = userService;
        this.shoppingCartService = shoppingCartService;
    }

    // adding a book
    @PostMapping("/book")
    public ResponseEntity<Book> createBook(@RequestBody Book book) {
        return ResponseEntity.ok().body(bookService.createBook(book));
    }

    // getting a book
    @GetMapping("/book/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable(value = "id") Long bookId) {
        Optional<Book> maybeBook = bookService.getBook(bookId);
        if (maybeBook.isEmpty())
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok().body(maybeBook.get());
    }

    // adding a user
    @PostMapping("/user")
    public ResponseEntity<User> createUser(@RequestBody User user) {
        return ResponseEntity.ok().body(userService.createUser(user));
    }

    // adding books to User's cart
    @PostMapping("/add-book-to-cart/{userId}/{bookId}/{quantity}")
    public ResponseEntity<String> addBookToCart(@PathVariable(value = "userId") Long userId, @PathVariable(value = "bookId") Long bookId, @PathVariable(value = "quantity") Long quantity) {
       List<ShoppingCart> userCarts = shoppingCartService.getByBookIdAndUserId(bookId, userId);
       if (userCarts.isEmpty()) {
           shoppingCartService.create(userId, bookId, quantity);
           return ResponseEntity.ok().body("Book added to User's cart!");
       }
       return ResponseEntity.ok().body("Book already in User's cart!");
    }
    // get total price from User's cart
    @GetMapping("/total-price/{userId}")
    public ResponseEntity<String> totalPrice(@PathVariable(value = "userId") Long userId) {
        return ResponseEntity.ok().body(String.valueOf("$"+ shoppingCartService.getTotalPrice(userId)));
    }
}




