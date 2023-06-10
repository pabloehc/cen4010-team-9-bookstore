package bookstore.repository;

import bookstore.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findAllById(Long id);
    List<User> findAllByUsername(String username);


}
