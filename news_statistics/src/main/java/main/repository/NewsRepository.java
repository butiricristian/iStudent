package main.repository;

import main.domain.News;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by Titus on 12/11/2017.
 */
public interface NewsRepository extends MongoRepository<News,Long> {
}
