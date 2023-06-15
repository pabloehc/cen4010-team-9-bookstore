package bookstore.repository;

import bookstore.model.ShoppingCart;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ShoppingCartRepository extends JpaRepository<ShoppingCart, Long> {
    List<ShoppingCart> findAllByUser_Id(Long user);
    List<ShoppingCart> findAllByUser_IdAndBook_Id(Long userId, Long bookId);
    List<ShoppingCart> findAllById(Long id);
    ShoppingCart findByUser_IdAndBook_Id(Long user_id, Long book_id);
    ShoppingCart deleteAllByBook_IdAndUser_IdAndQuantity(Long book_id, Long user_id, Long quantity);






}
