package bookstore.service;

import bookstore.model.ShoppingCart;

import java.util.List;

public interface ShoppingCartService {
    public String createShoppingCart(ShoppingCart cart);
    public String updateShoppingCart(ShoppingCart cart);
    public String deleteShoppingCart(String cartId);
    public ShoppingCart getShoppingCart(String cartId);
    public List<ShoppingCart> getAllShoppingCart();
    public List<ShoppingCart> getById(String cartId);
}
