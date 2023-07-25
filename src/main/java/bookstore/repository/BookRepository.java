package bookstore.repository;

import bookstore.model.Author;
import bookstore.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface BookRepository extends JpaRepository<Book, Long> {

  List<Book> findAllById(Long id);

  List<Book> findByGenre(String genre);
  List<Book> findByRatingGreaterThanEqual(Double rating);

  List<Book> findByPublisher(String publisher);

  @Query("SELECT b FROM Book b ORDER BY b.copiesSold DESC")
  List<Book> findTopSellers();


  List<Book> findByISBN(String isbn);


  List<Book> findAllByAuthor(String author);
}
