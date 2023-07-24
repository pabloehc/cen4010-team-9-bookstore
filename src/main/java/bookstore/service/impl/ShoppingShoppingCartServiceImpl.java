package bookstore.service.impl;

import bookstore.model.Book;
import bookstore.model.ShoppingCart;
import bookstore.model.User;
import bookstore.repository.BookRepository;
import bookstore.repository.ShoppingCartRepository;
import bookstore.repository.UserRepository;
import bookstore.service.ShoppingCartService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class ShoppingShoppingCartServiceImpl implements ShoppingCartService {

    ShoppingCartRepository shoppingCartRepository;
    UserRepository userRepository;
    BookRepository bookRepository;

    public ShoppingShoppingCartServiceImpl(ShoppingCartRepository shoppingCartRepository, UserRepository userRepository, BookRepository bookRepository) {
        this.shoppingCartRepository = shoppingCartRepository;
        this.userRepository = userRepository;
        this.bookRepository = bookRepository;
    }
    @Override
    public void create(Long userId, Long bookId, Long quantity) {
        ShoppingCart shoppingCart = new ShoppingCart();
        User user = userRepository.findById(userId).get();
        Book book = bookRepository.findById(bookId).get();
        shoppingCart.setUser(user);
        shoppingCart.setBook(book);
        shoppingCart.setQuantity(quantity);
        shoppingCart.setPrice(book.getPrice());
        shoppingCartRepository.save(shoppingCart);
    }

    @Override
    public double getTotalPrice(Long user) {
        double totalPrice = 0;
        for (ShoppingCart c : shoppingCartRepository.findAllByUser_Id(user)) {
            totalPrice += c.getPrice() * c.getQuantity();
        }
        return totalPrice;
    }

    @Override
    public List<Book> getAllCartItems(Long userId) {
        List<Book> books = new ArrayList<>();
       for (ShoppingCart s : shoppingCartRepository.findAllByUser_Id(userId)) {
           for (int i = 0; i < s.getQuantity(); i++) {
               books.add(s.getBook());
           }
       }
        return books;
    }

    @Override
    public List<ShoppingCart> getByBookIdAndUserId(Long bookId, Long userId) {
        return shoppingCartRepository.findAllByUser_IdAndBook_Id(userId, bookId);
    }
    @Override
    public void delete(Long book_id, Long user_id, Long quantity) {
        List<ShoppingCart> shoppingCart = shoppingCartRepository.findAllByUser_IdAndBook_Id(user_id, book_id);
        for (ShoppingCart c : shoppingCart) {
            c.setQuantity(c.getQuantity() - quantity);
            shoppingCartRepository.save(c);
            if (c.getQuantity() == 0) {
                shoppingCartRepository.delete(c);
            }
        }
    }

    @Override
    public void update(Long userId, Long bookId, Long quantity) {

        List<ShoppingCart> shoppingCart = shoppingCartRepository.findAllByUser_IdAndBook_Id(userId, bookId);
        for (ShoppingCart c : shoppingCart) {
            c.setQuantity(c.getQuantity() + quantity);
            shoppingCartRepository.save(c);
        }
    }

    }


