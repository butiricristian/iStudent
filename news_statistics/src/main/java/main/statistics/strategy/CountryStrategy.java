package main.statistics.strategy;

import main.domain.statistic.CountryStatistic;
import main.dto.NewsDto;

import java.util.List;


public class CountryStrategy implements StatisticStrategy<CountryStatistic> {

    public CountryStrategy() {
    }

    @Override
    public double calculateLikelyHood(NewsDto news, List<CountryStatistic> elements) {
        long total = elements.size();

        System.out.println(elements);
        long likesRegistered = news
                .getHashTags()
                .stream()
                .mapToLong(hashtag->
                        elements.stream()
                                .filter(genderStatistic -> genderStatistic.getHashTag().equals(hashtag))
                                .count()
                ).sum();
        return (double)likesRegistered /total;
    }
}
