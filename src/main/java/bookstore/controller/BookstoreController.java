package bookstore.controller;

import bookstore.model.Book;
import bookstore.service.BookService;
import bookstore.service.ShoppingCartService;
import bookstore.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.List;

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

    @PostMapping("/book")
    public ResponseEntity<Book> createBook(@RequestBody Book book) {
        return ResponseEntity.ok().body(bookService.createBook(book));
    }

    @GetMapping("/book/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable(value = "id") Long bookId) {
        Optional<Book> maybeBook = bookService.getBook(bookId);

        if (maybeBook.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok().body(maybeBook.get());
    }

    @GetMapping("/books/genre")
    public ResponseEntity<List<Book>> getBooksByGenre(@RequestParam String genre) {
        List<Book> books = bookService.getBooksByGenre(genre);

        if (books.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok().body(books);
    }
    @GetMapping("/books/rating")
    public ResponseEntity<List<Book>> getBooksByRating(@RequestParam Double rating) {
        List<Book> books = bookService.getBooksByRating(rating);

        if (books.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok().body(books);
    }
 }
