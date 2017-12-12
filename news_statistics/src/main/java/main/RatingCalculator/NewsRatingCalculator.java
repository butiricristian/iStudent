package main.RatingCalculator;

import main.domain.Country;
import main.domain.Gender;
import main.domain.NewsRating;
import main.dto.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Created by Titus on 12/12/2017.
 */
public class NewsRatingCalculator implements RatingCalculator<NewsRating> {
    public NewsGenderStatisticsDto calculateGenderStatistics(NewsRatingsDto newsRatingsDto){
        Map<String,Long> likes = newsRatingsDto.getNewsRatingDtoList()
                .stream()
                .map(rating->rating.getUser().getGender())
                .collect(Collectors.groupingBy(Gender::name,Collectors.counting()));

        return NewsGenderStatisticsDto.builder()
                .likesFromMen(likes.get(Gender.MALE))
                .likesFromWomen(likes.get(Gender.FEMALE))
                .build();
    }

    public NewsCountryStatisticsDto calculateCountryStatistics(NewsRatingsDto newsRatingsDto){
        List<NewsRatingDto> newsRatingDtoList = newsRatingsDto.getNewsRatingDtoList();
        Map<String,String> favoriteHashtagPerCountry = new HashMap<>();
        Set<Country> countrySet = newsRatingDtoList
                .stream()
                .map(rating->rating.getUser().getCountry())
                .collect(Collectors.toSet());
        Set<String> hashTags = newsRatingDtoList
                .stream()
                .flatMap(rating->rating.getSubject().getHashTags().stream())
                .collect(Collectors.toSet());
        countrySet.forEach(country->{
            String mostPopularHashtag=newsRatingDtoList
                    .stream()
                    .filter(rating->rating.getUser().getCountry() == country)
                    .flatMap(rating->rating.getSubject().getHashTags().stream())
                    .collect(Collectors.groupingBy(Function.identity(),Collectors.counting()))
                    .entrySet()
                    .stream()
                    .max(Map.Entry.comparingByValue())
                    .map(Map.Entry::getKey).orElse(null);
            favoriteHashtagPerCountry.put(country.name(), mostPopularHashtag);
        });
        return NewsCountryStatisticsDto
                .builder()
                .countryFavoriteHashtag(favoriteHashtagPerCountry)
                .build();
    }
}
