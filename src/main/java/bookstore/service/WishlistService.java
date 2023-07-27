package bookstore.service;

import bookstore.model.Wishlist;

import java.util.Optional;

public interface WishlistService {

    Wishlist createWishlist(String wishlistName, Long userId);
    Wishlist updateWishlist(Long bookId, Long wishlistId);
    Wishlist deleteFromWishlist(Long bookId, Long wishlistId);
    String getWishlist(Long wishlistId);
}
