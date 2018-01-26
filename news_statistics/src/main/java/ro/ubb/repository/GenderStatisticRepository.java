package ro.ubb.repository;

import ro.ubb.domain.statistic.GenderStatistic;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GenderStatisticRepository extends MongoRepository<GenderStatistic, Long> {
}
