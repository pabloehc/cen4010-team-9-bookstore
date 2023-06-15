package bookstore.service;

import bookstore.model.ShoppingCart;

import java.util.List;

public interface ShoppingCartService {

    public void create(Long userId, Long bookId, Long quantity);
    public double getTotalPrice(Long user);
    public List<ShoppingCart> getAllCartItems(Long userId);
    public List<ShoppingCart> getByBookIdAndUserId(Long bookId, Long userId);
}
