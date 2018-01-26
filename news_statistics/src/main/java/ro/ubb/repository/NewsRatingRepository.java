package ro.ubb.repository;

import ro.ubb.domain.rating.NewsRating;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Titus on 12/11/2017.
 */
@Repository
public interface NewsRatingRepository extends MongoRepository<NewsRating,Long> {
}
