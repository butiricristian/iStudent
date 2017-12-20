package ro.ubb.service;

import org.springframework.stereotype.Service;
import ro.ubb.dto.AgeAverageRatingDto;
import ro.ubb.dto.converter.AgeAverageRatingConverter;
import ro.ubb.model.AgeAverageRating;
import ro.ubb.model.NewsRating;
import ro.ubb.model.User;
import ro.ubb.service.utils.Utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Service
public class StatisticsService {

    Utils utils = new Utils();
    AgeAverageRatingConverter converter = new AgeAverageRatingConverter();

    public List<AgeAverageRatingDto> statisticsFromStudentsYoungerThan(int maxAge) {
        List<NewsRating> newsRatingList = utils.populateNewsRating(utils.populateUsers());

        Predicate<NewsRating> ageFilter = newsRating -> {
            User user = newsRating.getUser();
            return user.getAge() < maxAge;
        };

        List<AgeAverageRating> ageStatistics = statisticsGenerator(newsRatingList, ageFilter);
        return converter.mapToDTOs(ageStatistics);
    }


    public List<AgeAverageRatingDto> statisticsFromStudentsOlderThan(int minAge) {
        List<NewsRating> newsRatingList = utils.populateNewsRating(utils.populateUsers());

        Predicate<NewsRating> ageFilter = newsRating -> {
            User user = newsRating.getUser();
            return user.getAge() > minAge;
        };

        List<AgeAverageRating> ageStatistics = statisticsGenerator(newsRatingList, ageFilter);
        return converter.mapToDTOs(ageStatistics);
    }


    public List<AgeAverageRatingDto> statisticsFromStudentsAgedBetween(int age1, int age2) {
        List<NewsRating> newsRatingList = utils.populateNewsRating(utils.populateUsers());

        Predicate<NewsRating> ageFilter = newsRating -> {
            int userAge = newsRating.getUser().getAge();
            return userAge > age1 && userAge < age2;
        };

        List<AgeAverageRating> ageStatistics = statisticsGenerator(newsRatingList, ageFilter);
        return converter.mapToDTOs(ageStatistics);
    }

    private List<AgeAverageRating> statisticsGenerator(List<NewsRating> newsRatingList, Predicate<NewsRating> p) {
        List<AgeAverageRating> averageRatings = new ArrayList<>();

        List<NewsRating> filteredNewsRatingByAgeGroup = filteredNewsRatings(newsRatingList, p);

        extractAges(filteredNewsRatingByAgeGroup).stream().forEach(age -> {
            Double average = averageRatingFromStudentsWithAge(filteredNewsRatingByAgeGroup, age);
            averageRatings.add(new AgeAverageRating(age, average));
        });

        return averageRatings;
    }


    private List<Integer> extractAges(List<NewsRating> newsRatings) {
        List<Integer> ages = newsRatings.stream().map(newsRating -> newsRating.getUser().getAge()).collect(Collectors.toList());
        Collections.sort(ages);
        return ages;
    }


    private List<NewsRating> filteredNewsRatings(List<NewsRating> newsRatings, Predicate<NewsRating> ageFilter) {

        List<NewsRating> res = newsRatings.stream()
                .filter(ageFilter)
                .collect(Collectors.toList());
        return res;
    }


    private double averageRatingFromStudentsWithAge(List<NewsRating> newsRatingList, int age) {
        List<NewsRating> ratingsFromStudentsWithAge = newsRatingList.stream()
                .filter(newsRating -> {
                    User student = newsRating.getUser();
                    return student.getAge() == age;
                })
                .collect(Collectors.toList());

        long no = ratingsFromStudentsWithAge.size();
        double sum = ratingsFromStudentsWithAge.stream().map(newsRating -> newsRating.getScore()).mapToDouble(i -> i).sum();
        return utils.round(sum / no, 2);
    }
}
