package main.repository;

import main.domain.NewsRating;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by Titus on 12/11/2017.
 */
public interface NewsRatingRepository extends MongoRepository<NewsRating,Long> {
}
