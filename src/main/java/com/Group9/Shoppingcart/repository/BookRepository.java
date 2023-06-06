package com.Group9.Shoppingcart.repository;

import com.Group9.Shoppingcart.model.Book;
import com.Group9.Shoppingcart.model.CartItem;
import com.Group9.Shoppingcart.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {
    @Query("SELECT b FROM Book b")
    List<Book> getAllBooks();

    void getById(Book id);

}
