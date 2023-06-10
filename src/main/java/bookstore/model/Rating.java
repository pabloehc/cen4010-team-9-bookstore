package bookstore.model;

import jakarta.persistence.*;

@Entity
public class Rating {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // A user can leave many ratings
    @ManyToOne
    @JoinColumn(name = "userId", referencedColumnName = "id")
    private User user;

    // A book can have many ratings
    @ManyToOne
    @JoinColumn(name = "bookId", referencedColumnName = "id")
    private Book book;

    private int rating;
}
