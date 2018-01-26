package main.repository;

import main.domain.statistic.GenderStatistic;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GenderStatisticRepository extends MongoRepository<GenderStatistic, Long> {
}
