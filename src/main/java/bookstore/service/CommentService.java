package bookstore.service;

import bookstore.model.Comment;
import bookstore.model.Rating;

import java.util.List;

public interface CommentService {
    public Comment create(Comment comment);
    public List<Comment> findByBookId(Long bookId);
}
