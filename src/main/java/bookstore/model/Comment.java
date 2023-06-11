package bookstore.model;

import jakarta.persistence.*;

@Entity
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // A user can leave many comments
    @ManyToOne
    @JoinColumn(name = "userId", referencedColumnName = "id")
    private User user;

    // A book can have many comments
    @ManyToOne
    @JoinColumn(name = "bookId", referencedColumnName = "id")
    private Book book;

    private String comment;
}
