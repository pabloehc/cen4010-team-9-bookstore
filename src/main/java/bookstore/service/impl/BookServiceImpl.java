package bookstore.service.impl;

import bookstore.repository.BookRepository;
import bookstore.model.Book;
import bookstore.service.BookService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {
    BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public Book createBook(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public String updateBook(Book book) {
        return null;
    }

    @Override
    public String deleteBook(String bookId) {
        return null;
    }

    @Override
    public Optional<Book> getBook(Long bookId) {
        return bookRepository.findById(bookId);
    }

    @Override
    public List<Book> getAllCBooks() {
        return bookRepository.findAll();
    }

    @Override
    public List<Book> getBooksByGenre(String genre) {
        return bookRepository.findByGenre(genre);
    }

    @Override
    public List<Book> getByISBN(String isbn) {
        return null;
    }

    public List<Book> getBooksByRating(Double rating) {
        return bookRepository.findByRatingGreaterThanEqual(rating);
    }
}
