package bookstore.service.impl;

import bookstore.model.Comment;
import bookstore.repository.CommentRepository;
import bookstore.repository.RatingRepository;
import bookstore.service.CommentService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {

    CommentRepository commentRepository;

    public CommentServiceImpl(CommentRepository commentRepository)
    {
        this.commentRepository = commentRepository;
    }

    @Override
    public Comment create(Comment comment) {
        return commentRepository.save(comment);
    }

    @Override
    public List<Comment> findByBookId(Long bookId) {
        return commentRepository.findAllByBookId(bookId);
    }
}
