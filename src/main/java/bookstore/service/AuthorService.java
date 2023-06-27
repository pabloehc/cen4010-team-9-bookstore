package bookstore.service;

import bookstore.model.Author;
import bookstore.model.Book;

import java.util.List;
import java.util.Optional;

public interface AuthorService
{
    public Author createAuthor(Author author);
    public Author updateAuthor(Long id, Author author);
    public void deleteAuthor(Long id);
    public String getAuthorFullName(Long id);
}
