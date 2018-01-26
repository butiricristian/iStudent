package main.strategy;

import lombok.NoArgsConstructor;
import main.domain.statistic.CountryStatistic;
import main.dto.NewsDto;

import java.util.List;

@NoArgsConstructor
public class CountryStrategy implements StatisticStrategy<CountryStatistic> {

    @Override
    public double calculateLikelyHood(NewsDto news, List<CountryStatistic> elements) {
        long total = elements.size();

        long likesRegistered = news
                .getHashTags()
                .stream()
                .mapToLong(hashtag->
                        elements.stream()
                                .filter(genderStatistic -> genderStatistic.getHashTag().equals(hashtag))
                                .count()
                ).sum();

        return likesRegistered /total;
    }
}
