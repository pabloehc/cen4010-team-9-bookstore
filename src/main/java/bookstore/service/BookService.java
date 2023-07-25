package bookstore.service;

import bookstore.model.Author;
import bookstore.model.Book;

import java.util.List;
import java.util.Optional;

public interface BookService {
    public Book createBook(Book book);
    public Book updateBook(Long bookId, Book book);
    public void deleteBook(Long bookId);
    public Optional<Book> getBook(Long bookId);
    public List<Book> getAllCBooks();


    List<Book> getBooksByGenre(String genre);
    List<Book> getBooksByRating(Double rating);

    public List<Book> findByISBN(String isbn);
    public List<Book> getByAuthor(String author);

    List<Book> getTopSellersBooks();

    void discountBooksByPublisher(String publisher, Double discountPercent);
}
