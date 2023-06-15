package bookstore.service.impl;

import bookstore.model.Book;
import bookstore.model.ShoppingCart;
import bookstore.model.User;
import bookstore.repository.BookRepository;
import bookstore.repository.ShoppingCartRepository;
import bookstore.repository.UserRepository;
import bookstore.service.ShoppingCartService;
import org.springframework.stereotype.Service;

import java.util.List;

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
    public void create(Long userId, Long bookId) {

        ShoppingCart shoppingCart = new ShoppingCart();
        User user = userRepository.findById(userId).get();
        Book book = bookRepository.findById(bookId).get();
        shoppingCart.setUser(user);
        shoppingCart.setBook(book);
        shoppingCart.setQuantity(1);
        shoppingCart.setPrice(book.getPrice());
        shoppingCartRepository.save(shoppingCart);
    }

    @Override
    public double getTotalPrice(Long user) {
        double totalPrice = 0;
        for (ShoppingCart c : shoppingCartRepository.findAllById(user)) {
        }
        return totalPrice;
    }


    @Override
    public List<ShoppingCart> getAllCartItems(Long userId) {
      return shoppingCartRepository.findAllByUser_Id(userId).stream().toList();
    }

    @Override
    public List<ShoppingCart> getByBookIdAndUserId(Long bookId, Long userId) {
        return shoppingCartRepository.findAllByUser_IdAndBook_Id(userId, bookId);
    }
}
