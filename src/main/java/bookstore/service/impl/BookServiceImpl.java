package bookstore.service.impl;

import bookstore.model.Author;
import bookstore.repository.AuthorRepository;
import bookstore.repository.BookRepository;
import bookstore.model.Book;
import bookstore.service.BookService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {
    BookRepository bookRepository;
    AuthorRepository authorRepository;
    AuthorServiceImpl authorService;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public Book createBook(Book book)
    {
        return bookRepository.save(book);
    }

    @Override
    public Book updateBook(Long bookId, Book book)
    {
        Book update = bookRepository.findById(bookId).get();
        update.setISBN(book.getISBN());
        update.setName(book.getName());
        update.setDescription(book.getDescription());
        update.setPrice(book.getPrice());
        update.setAuthor(book.getAuthor());
        update.setGenre(book.getGenre());
        update.setPublisher(book.getPublisher());
        update.setYearPublished(book.getYearPublished());
        update.setCopiesSold(book.getCopiesSold());
        return bookRepository.save(update);
    }

    @Override
    public void deleteBook(Long bookId)
    {
        Book delete = bookRepository.findById(bookId).get();
        bookRepository.delete(delete);
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

    public List<Book> findByISBN(String isbn)
    {
        return bookRepository.findByISBN(isbn);
    }
    @Override
    public List<Book> getByAuthor(String author)
    {
        return bookRepository.findAllByAuthor(author);
    }

    public List<Book> getBooksByRating(Double rating) {
        return bookRepository.findByRatingGreaterThanEqual(rating);
    }

    public List<Book> getTopSellersBooks() {
        List<Book> books = bookRepository.findTopSellers();
        return books.size() > 10 ? books.subList(0, 10) : books;
    }
    @Transactional
    public void discountBooksByPublisher(String publisher, Double discountPercent) {
        List<Book> books = bookRepository.findByPublisher(publisher);
        for (Book book : books) {
            double newPrice = book.getPrice() * (1 - discountPercent/100);
            book.setPrice(newPrice);
        }
    }
}
