package bookstore.repository;

import bookstore.model.Author;
import bookstore.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AuthorRepository extends JpaRepository<Author, Long>
{
}
