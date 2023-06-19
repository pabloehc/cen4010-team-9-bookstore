package bookstore.service.impl;

import bookstore.model.Author;
import bookstore.repository.AuthorRepository;
import bookstore.service.AuthorService;
import org.springframework.stereotype.Service;

@Service
public class AuthorServiceImpl implements AuthorService
{
    AuthorRepository authorRepository;
    public Author createAuthor(Author author)
    {
        return authorRepository.save(author);
    }
    public Author updateAuthor(Long id, Author author)
    {
        Author update = authorRepository.findById(id).get();
        update.setFirstName(author.getFirstName());
        update.setLastName(author.getLastName());
        update.setBiography(author.getBiography());
        update.setPublisher(author.getPublisher());
        return authorRepository.save(update);
    }
    public void deleteAuthor(Long id)
    {
        Author delete = authorRepository.findById(id).get();
        authorRepository.delete(delete);
    }
}
