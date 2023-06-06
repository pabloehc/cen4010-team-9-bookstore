package com.Group9.Shoppingcart.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;

import java.util.Objects;

 @Entity
public class CartItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private ShoppingCart shoppingCart;
    @ManyToOne
    private User user;
    @ManyToOne
    private Book book;
    private int quantity;
    private double totalPrice;


     public CartItem() {
    }

    public CartItem(User user, Book book) {
        this.user = user;
        this.book = book;
        shoppingCart = new ShoppingCart();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ShoppingCart getShoppingCart() {
        return shoppingCart;
    }

    public void setShoppingCart(ShoppingCart shoppingCart) {
        this.shoppingCart = shoppingCart;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

     public double getTotalPrice() {
         totalPrice = quantity * book.getPrice();
         return totalPrice;
     }

     public void setTotalPrice(double totalPrice) {
         this.totalPrice = totalPrice;
     }

     public double getUserTotal() {
       return shoppingCart.getCartItems().stream().mapToDouble(CartItem::getTotalPrice).sum();
    }

    @Override
    public String toString() {
        return "CartItem{" +
                "id=" + id +
                ", shoppingCart=" + shoppingCart +
                ", user=" + user +
                ", book=" + book +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CartItem cartItem = (CartItem) o;
        return Objects.equals(id, cartItem.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
