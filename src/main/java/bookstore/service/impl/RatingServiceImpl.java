package bookstore.service.impl;

import bookstore.model.Rating;
import bookstore.repository.AuthorRepository;
import bookstore.repository.RatingRepository;
import bookstore.service.RatingService;
import org.springframework.stereotype.Service;

@Service
public class RatingServiceImpl implements RatingService {

    RatingRepository ratingRepository;

    public RatingServiceImpl(RatingRepository ratingRepository)
    {
        this.ratingRepository = ratingRepository;
    }

    @Override
    public Rating create(Rating rating) {
        return ratingRepository.save(rating);
    }

    @Override
    public Double getAverageRating(Long bookId) {
        var ratings = ratingRepository.findAllByBookId(bookId);
        var average = ratings.stream().mapToDouble(rating -> rating.getRating()).average();

        if (average.isEmpty()) {
            return (double) 0;
        }

        return average.getAsDouble();
    }
}
