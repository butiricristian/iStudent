package ro.ubb.repository;

import ro.ubb.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by Titus on 12/11/2017.
 */
public interface UserRepository extends MongoRepository<User,Long>{
}
