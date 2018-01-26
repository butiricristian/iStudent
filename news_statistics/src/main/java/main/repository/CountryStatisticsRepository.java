package main.repository;

import main.domain.statistic.CountryStatistic;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CountryStatisticsRepository extends MongoRepository<CountryStatistic, Long>{
}
