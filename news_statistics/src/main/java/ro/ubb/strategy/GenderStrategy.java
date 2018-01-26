package ro.ubb.strategy;


import ro.ubb.domain.statistic.GenderStatistic;
import ro.ubb.dto.NewsDto;

import java.util.List;
public class GenderStrategy implements StatisticStrategy<GenderStatistic>{
    public GenderStrategy() {
    }

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
