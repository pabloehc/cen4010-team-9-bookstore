package bookstore.model;

import com.google.gson.GsonBuilder;
import jakarta.persistence.*;
import java.util.*;
import com.google.gson.Gson;

@Entity
public class Wishlist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long userId;
    private String wishlistName;
    @OneToMany
    private List<Book> books;

    public Wishlist(){
    }

    public Wishlist(Long userId, String wishlistName){
        this.userId = userId;
        this.wishlistName = wishlistName;
        this.books = new ArrayList<>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
    public String getWishlistName() {return wishlistName;}

    public void setWishlistName(String wishlistName) {
        this.wishlistName = wishlistName;
    }

    public void addBooks(Book book) {
        books.add(book);
    }
    public void removeBooks(Long bookId){
        this.books.removeIf(book -> book.getId() == bookId);
    }
    public String getBooks(){
        return "Books{" + books +'\'' +"}";
    }
    public String getBooksJson(){
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        return gson.toJson(books);
    }

    @Override
    public String toString() {
        return "Wishlist{" +
                "id=" + id +
                ", userId=" + userId +
                ", wishlistName='" + wishlistName + '\'' +
                ", books=" + books +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Wishlist wishlist = (Wishlist) o;
        return Objects.equals(id, wishlist.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
