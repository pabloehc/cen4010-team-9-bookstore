package bookstore.repository;

import bookstore.model.ShoppingCart;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ShoppingCartRepository extends JpaRepository<ShoppingCart, Long> {
    List<ShoppingCart> findAllByUser_Id(Long user);
    List<ShoppingCart> findAllByUser_IdAndBook_Id(Long userId, Long bookId);
}
