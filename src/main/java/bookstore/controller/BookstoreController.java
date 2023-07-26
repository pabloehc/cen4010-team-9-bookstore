package bookstore.controller;

import bookstore.model.*;
import bookstore.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.DecimalFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.List;

@RestController
@RequestMapping("/bookstore")
public class BookstoreController {

    private final BookService bookService;
    private final AuthorService authorService;
    private final UserService userService;
    private final ShoppingCartService shoppingCartService;
    private final WishlistService wishlistService;
    private final RatingService ratingService;
    private final CommentService commentService;

    @Autowired
    public BookstoreController(BookService bookService, AuthorService authorService, UserService userService,
                               ShoppingCartService shoppingCartService, WishlistService wishlistService,
                               RatingService ratingService, CommentService commentService) {
        this.bookService = bookService;
        this.userService = userService;
        this.shoppingCartService = shoppingCartService;
        this.authorService = authorService;
        this.wishlistService = wishlistService;
        this.ratingService = ratingService;
        this.commentService = commentService;
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

    //adding an author
    @PostMapping("/author")
    public ResponseEntity<Author> createAuthor(@RequestBody Author author) {
        return ResponseEntity.ok().body(authorService.createAuthor(author));
    }

    //getting books from author id
    @GetMapping("/author/{id}")
    public ResponseEntity<List<Book>> getBooksByAuthor(@PathVariable(value = "id") Long authorId) {
        return ResponseEntity.ok().body(bookService.getByAuthor(authorService.getAuthorFullName(authorId)));
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
                return ResponseEntity.badRequest().body("Number of books with bookId: " + bookId + " to delete from User's cart (" + quantity + ") is greater than the total (" + cart.getQuantity() + ") of books with bookId: " + bookId + " in User's cart!");
            } else if (cart.getQuantity() - quantity == 0) {
                shoppingCartService.delete(bookId, userId, quantity);
                return ResponseEntity.ok().body(quantity + " book/s with bookId: " + bookId + " was/were deleted from User's cart!\n" +
                        "No books with bookId: " + bookId + " left in User's cart!");
            }
            shoppingCartService.delete(bookId, userId, quantity);
            return ResponseEntity.ok().body(quantity + " book/s with bookId: " + bookId + " was/were deleted from User's cart!\n" +
                    "Total book/s with bookId: " + bookId + " in User's cart: " + cart.getQuantity());
        }
        return ResponseEntity.badRequest().body("No books with bookId: " + bookId + " left in User's cart!");
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

    @PostMapping("/rating")
    public ResponseEntity<Rating> createBook(@RequestBody Rating rating) {
        rating.setDate(new Date());
        return ResponseEntity.ok().body(ratingService.create(rating));
    }

    @GetMapping("/books/genre")
    public ResponseEntity<List<Book>> getBooksByGenre(@RequestParam String genre) {
        List<Book> books = bookService.getBooksByGenre(genre);

        if (books.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok().body(books);
    }

    @GetMapping("/rating/average/{bookId}")
    public ResponseEntity<String> getBookAverageRating(@PathVariable(value = "bookId") Long bookId) {
        var format = new DecimalFormat("#.#");
        var average = ratingService.getAverageRating(bookId);
        return ResponseEntity.ok().body(format.format(average));
    }

    @PostMapping("/comment")
    public ResponseEntity<Comment> createComment(@RequestBody Comment comment) {
        comment.setDate(new Date());
        return ResponseEntity.ok().body(commentService.create(comment));
    }

    @GetMapping("/comment/book/{bookId}")
    public ResponseEntity<List<Comment>> getCommentsForBook(@PathVariable(value = "bookId") Long bookId) {
        return ResponseEntity.ok().body(commentService.findByBookId(bookId));
    }

    //creating wishlist
    @PostMapping("/wishlist/{wishlistName}/{userId}")
    public ResponseEntity<Wishlist> createWishlist(@RequestBody @PathVariable (value = "wishlistName") String wishlistName, @PathVariable(value = "userId") Long userId){
        return ResponseEntity.ok().body(wishlistService.createWishlist(wishlistName, userId));
    }
    //add a book to user's wishlist
    @PostMapping("/wishlist/{bookId}/{id}")
    public ResponseEntity<Wishlist> updateWishlist(@RequestBody @PathVariable(value = "bookId") Long bookId, @PathVariable(value = "id") Long wishlistId){
        return ResponseEntity.ok().body(wishlistService.updateWishlist(bookId, wishlistId));
    }
    //remove a book from user's wishlist
    @DeleteMapping("/wishlist/{bookId}/{id}")
    public ResponseEntity<Wishlist> deleteFromWishlist(@RequestBody @PathVariable (value = "bookId") Long bookId, @PathVariable(value = "id") Long wishlistId) {
        return ResponseEntity.ok().body(wishlistService.deleteFromWishlist(bookId, wishlistId));
    }
    //get list of books from user's wishlist
    @GetMapping("wishlist/{id}")
    public ResponseEntity<Optional<Wishlist>> getWishlist(@RequestBody @PathVariable(value = "id") Long wishlistId) {
        return ResponseEntity.ok().body(wishlistService.getWishlist(wishlistId));
    }

    @GetMapping("/books/top-sellers")
    public ResponseEntity<List<Book>> getTopSellers() {
        List<Book> books = bookService.getTopSellersBooks();

        if (books.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok().body(books);
    }
    @PatchMapping("/books/discount")
    public ResponseEntity<Void> discountBooksByPublisher(
            @RequestParam String publisher,
            @RequestParam Double discountPercent) {

        bookService.discountBooksByPublisher(publisher, discountPercent);
        return ResponseEntity.noContent().build();
    }
}


