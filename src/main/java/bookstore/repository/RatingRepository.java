package bookstore.repository;

import bookstore.model.Book;
import bookstore.model.Rating;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RatingRepository extends JpaRepository<Rating, Long> {
    List<Rating> findAllByBookId(Long bookId);
}
