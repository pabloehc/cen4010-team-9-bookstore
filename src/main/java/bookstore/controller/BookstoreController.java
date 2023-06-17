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
import java.util.Set;

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

    // adding books to User's cart (ShoppingCart Post Request)
    @PostMapping("/add-book-to-cart/{userId}/{bookId}/{quantity}")
    public ResponseEntity<String> addBookToCart(@PathVariable(value = "userId") Long userId, @PathVariable(value = "bookId") Long bookId, @PathVariable(value = "quantity") Long quantity) {
       List<ShoppingCart> userCarts = shoppingCartService.getByBookIdAndUserId(bookId, userId);

       if (userCarts.isEmpty()) {
           shoppingCartService.create(userId, bookId, quantity);
           return ResponseEntity.ok().body(quantity + " book/s with bookId: "+ bookId +" was/were added to User's cart!");
       }
       shoppingCartService.update(userId, bookId, quantity);
       return ResponseEntity.ok().body(quantity + " book/s with bookId: "+ bookId +" was/were added to User's cart!\n" +
               "The total book/s with bookId: "+ bookId +" in User's cart: " + userCarts.get(0).getQuantity());
    }

    // delete book/s from User's cart (ShoppingCart Delete Request)
    @DeleteMapping("/delete-book-from-cart/{userId}/{bookId}/{quantity}")
    public ResponseEntity<String> delete(@PathVariable(value = "userId") Long userId, @PathVariable(value = "bookId") Long bookId, @PathVariable(value = "quantity") Long quantity) {
        List<ShoppingCart> userCarts = shoppingCartService.getByBookIdAndUserId(bookId, userId);
        for (ShoppingCart cart : userCarts) {
            if (cart.getQuantity() - quantity < 0) {
                return ResponseEntity.badRequest().body("Number of books with bookId: " + bookId +" to delete from User's cart (" + quantity + ") is greater than the total (" + cart.getQuantity() + ") of books with bookId: " + bookId + " in User's cart!");
            }
            else if (cart.getQuantity() - quantity == 0) {
                shoppingCartService.delete(bookId, userId, quantity);
                return ResponseEntity.ok().body(quantity + " book/s with bookId: "+ bookId +" was/were deleted from User's cart!\n" +
                        "No books with bookId: "+ bookId +" left in User's cart!");
            }
            shoppingCartService.delete(bookId, userId, quantity);
            return ResponseEntity.ok().body(quantity + " book/s with bookId: "+ bookId +" was/were deleted from User's cart!\n"+
                    "Total book/s with bookId: "+ bookId +" in User's cart: " + cart.getQuantity());
        }
        return ResponseEntity.badRequest().body("No books with bookId: " + bookId +" left in User's cart!");
    }

    // get all books in User's cart (ShoppingCart Get Request)
    @GetMapping("/list-books-in-cart/{userId}")
    public ResponseEntity<List<Book>> listBooksInCart(@PathVariable(value = "userId") Long userId) {
        if (shoppingCartService.getAllCartItems(userId).isEmpty())
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok().body(shoppingCartService.getAllCartItems(userId));
    }
    // get total price from User's cart (ShoppingCart Get Request)
    @GetMapping("/total-price/{userId}")
    public ResponseEntity<String> totalPrice(@PathVariable(value = "userId") Long userId) {
        return ResponseEntity.ok().body("$" + shoppingCartService.getTotalPrice(userId));
    }
}
