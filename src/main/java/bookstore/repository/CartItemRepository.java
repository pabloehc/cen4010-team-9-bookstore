package bookstore.repository;

import bookstore.model.Book;
import bookstore.model.CartItem;
import bookstore.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CartItemRepository extends JpaRepository<CartItem, Long> {
    List<CartItem> findAllByUser(User user);
    List<CartItem> findAllByUserAndBook(User user, Book book);
    List<CartItem> findAllById(Long id);

}
