package bookstore.service;

import bookstore.model.Wishlist;

import java.util.Optional;

public interface WishlistService {

    Wishlist createWishlist(String wishlistName, Long userId);
    public Wishlist updateWishlist(Long bookId, Long wishlistId);
    Wishlist deleteFromWishlist(Long bookId, Long wishlistId);
    Optional<Wishlist> getWishlist(Long wishlistId);
}
