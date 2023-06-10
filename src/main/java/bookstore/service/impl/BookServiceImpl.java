package bookstore.service.impl;

import bookstore.repository.BookRepository;
import bookstore.model.Book;
import bookstore.service.BookService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BookServiceImpl implements BookService {
    BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public String createBook(Book book) {
        bookRepository.save(book);
        return "Book created successfully";
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
    public Book getBook(String bookId) {
        return null;
    }

    @Override
    public List<Book> getAllCBooks() {
        return bookRepository.findAll();
    }

    @Override
    public List<Book> getByISBN(String isbn) {
        return null;
    }
}
