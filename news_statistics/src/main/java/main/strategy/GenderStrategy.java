package main.strategy;

import lombok.NoArgsConstructor;
import main.domain.statistic.GenderStatistic;
import main.dto.NewsDto;

import java.util.List;

@NoArgsConstructor
public class GenderStrategy implements StatisticStrategy<GenderStatistic>{
    @Override
    public double calculateLikelyHood(NewsDto news, List<GenderStatistic> elements) {
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
