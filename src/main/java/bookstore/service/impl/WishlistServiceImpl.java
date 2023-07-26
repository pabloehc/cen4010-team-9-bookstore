package bookstore.service.impl;

import bookstore.model.Wishlist;
import bookstore.model.Book;
import bookstore.service.WishlistService;
import bookstore.service.BookService;
import bookstore.repository.BookRepository;
import bookstore.repository.WishlistRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WishlistServiceImpl implements WishlistService {

    WishlistRepository wishlistRepository;
    BookRepository bookRepository;

    public WishlistServiceImpl(WishlistRepository wishlistRepository, BookRepository bookRepository){
        this.wishlistRepository = wishlistRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public Wishlist createWishlist(String wishlistName, Long userId) {
        Wishlist create = new Wishlist();
        create.setWishlistName(wishlistName);
        create.setUserId(userId);
        return wishlistRepository.save(create);
    }

    @Override
    public Wishlist updateWishlist(Long bookId, Long wishlistId) {
        Wishlist update = wishlistRepository.findById(wishlistId).get();
        Book book = bookRepository.findById(bookId).get();
        update.addBooks(book);
        return wishlistRepository.save(update);
    }

    @Override
    public Wishlist deleteFromWishlist(Long bookId, Long wishlistId) {
        Wishlist delete = wishlistRepository.findById(wishlistId).get();
        delete.removeBooks(bookId);
        return wishlistRepository.save(delete);
    }
    @Override
    public String getWishlist(Long wishlistId) {
        Wishlist wishlist = wishlistRepository.findById(wishlistId).get();
        return wishlist.getBooksJson();
    }
}
