package bookstore.repository;

import bookstore.model.User;
import bookstore.model.Wishlist;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WishlistRepository extends JpaRepository <Wishlist, Long>{

    List<Wishlist> findAllById(Long id);
    List<Wishlist> findAllByUserAndId(User user, Long id);
    List<Wishlist> findAllByUser(User user);
}
