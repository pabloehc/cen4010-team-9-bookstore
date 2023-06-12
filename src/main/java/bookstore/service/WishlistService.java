package bookstore.service;

import bookstore.model.Wishlist;

import java.util.List;

public interface WishlistService {

    public String createWishlist(Wishlist wishlist);
    public String updateWishlist(Wishlist wishlist);
    public String deleteWishlist(String wishlistId);
    public Wishlist getWishlist(String wishlistId);
    public List<Wishlist> getAllWishlists();
    public List<Wishlist> getById(String wishlistId);
}
