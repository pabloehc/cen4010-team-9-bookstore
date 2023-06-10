package bookstore.service.impl;

import bookstore.repository.ShoppingCartRepository;
import bookstore.model.ShoppingCart;
import bookstore.service.ShoppingCartService;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShoppingCartImpl implements ShoppingCartService {
    ShoppingCartRepository repository;

    public ShoppingCartImpl(ShoppingCartRepository repository) {
        this.repository = repository;
    }
    @Override
    public String createShoppingCart(ShoppingCart cart) {
        return null;
    }

    @Override
    public String updateShoppingCart(ShoppingCart cart) {
        return null;
    }

    @Override
    public String deleteShoppingCart(String cartId) {
        return null;
    }

    @Override
    public ShoppingCart getShoppingCart(String cartId) {
        return null;
    }

    @Override
    public List<ShoppingCart> getAllShoppingCart() {
        return null;
    }

    @Override
    public List<ShoppingCart> getById(String cartId) {
        return null;
    }
}

