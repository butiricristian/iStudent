package ro.ubb.repository;

import ro.ubb.domain.DummyClass;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface DummyRepo extends MongoRepository<DummyClass, Long> {
}
