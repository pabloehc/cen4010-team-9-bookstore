package bookstore.service;

import bookstore.model.Book;

import java.util.List;

public interface BookService {
    public String createBook(Book book);
    public String updateBook(Book book);
    public String deleteBook(String bookId);
    public Book getBook(String bookId);
    public List<Book> getAllCBooks();
    public List<Book> getByISBN(String isbn);

}
