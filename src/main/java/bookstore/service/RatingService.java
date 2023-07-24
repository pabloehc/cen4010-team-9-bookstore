package bookstore.service;

import bookstore.model.Book;
import bookstore.model.Rating;

public interface RatingService {
    public Rating create(Rating rating);
    public Double getAverageRating(Long bookId);
}
