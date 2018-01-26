package ro.ubb.calculator.rating;

import ro.ubb.domain.enum_model.Gender;
import ro.ubb.dto.rating.NewsRatingsDto;
import ro.ubb.dto.statistic.NewsCountryStatisticsDto;
import ro.ubb.domain.enum_model.Country;
import ro.ubb.dto.rating.NewsRatingDto;
import ro.ubb.dto.statistic.NewsGenderStatisticsDto;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Created by Titus on 12/12/2017.
 */
@Component
public class NewsRatingCalculator implements RatingCalculator {
    public NewsGenderStatisticsDto calculateGenderStatistics(NewsRatingsDto newsRatingsDto){

        List<NewsRatingDto> newsRatingDtoList = newsRatingsDto.getNewsRatingDtoList();
        Map<String, String> favoriteHashtagPerGender = new HashMap<>();
        Set<String> genders = new HashSet<>();
        genders.add(Gender.MALE.name());
        genders.add(Gender.FEMALE.name());

        genders.forEach(gender ->{
            String mostPopularHashtag=newsRatingDtoList
                    .stream()
                    .filter(rating->rating.getUser().getGender().name().equals(gender))
                    .flatMap(rating->rating.getSubject().getHashTags().stream())
                    .collect(Collectors.groupingBy(Function.identity(),Collectors.counting()))
                    .entrySet()
                    .stream()
                    .max(Map.Entry.comparingByValue())
                    .map(Map.Entry::getKey).orElse(null);
            favoriteHashtagPerGender.put(gender, mostPopularHashtag);
        });
        return new NewsGenderStatisticsDto(favoriteHashtagPerGender);
    }

    public NewsCountryStatisticsDto calculateCountryStatistics(NewsRatingsDto newsRatingsDto){
        List<NewsRatingDto> newsRatingDtoList = newsRatingsDto.getNewsRatingDtoList();
        Map<String,String> favoriteHashtagPerCountry = new HashMap<>();
        Set<Country> countrySet = newsRatingDtoList
                .stream()
                .map(rating->rating.getUser().getCountry())
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
        return new NewsCountryStatisticsDto(favoriteHashtagPerCountry);
    }
}
