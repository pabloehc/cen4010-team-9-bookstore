package bookstore.repository;

import bookstore.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface BookRepository extends JpaRepository<Book, Long> {

  List<Book> findAllById(Long id);

  List<Book> findAllByISBN(String isbn);


}
