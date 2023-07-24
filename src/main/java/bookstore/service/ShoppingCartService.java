package bookstore.service;

import bookstore.model.Book;
import bookstore.model.ShoppingCart;

import java.util.List;
import java.util.Set;

public interface ShoppingCartService {

    public void create(Long userId, Long bookId, Long quantity);
    public double getTotalPrice(Long user);
    public List<Book> getAllCartItems(Long userId);
    public List<ShoppingCart> getByBookIdAndUserId(Long bookId, Long userId);
    public void delete(Long book_id, Long user_id, Long quantity);
    public void update(Long userId, Long bookId, Long quantity);
}
