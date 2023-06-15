package bookstore.model;

import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;

 @Entity
 public class ShoppingCart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private User user;
    @ManyToOne
    private Book book;
    private int quantity;
    private double price;


    public ShoppingCart() {
    }

    public ShoppingCart(User user, Book book) {
        this.user = user;
        this.book = book;
        price = book.getPrice();
        quantity = 1;
    }

     public Long getId() {
         return id;
     }

     public void setId(Long id) {
         this.id = id;
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

     public double getPrice() {
         return price = book.getPrice();
     }

     public void setPrice(double price) {
         this.price = price;
     }

     @Override
    public String toString() {
        return "ShoppingCart{" +
                "id=" + id +
                ", user=" + user +
                ", book=" + book +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ShoppingCart shoppingCart = (ShoppingCart) o;
        return Objects.equals(id, shoppingCart.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public List<Book> getBooks() {
        return user.getBooks();
    }

     public Object getBookId() {
         return book.getId();
     }
 }
