package main.rest;

import main.calculator.rating.LikelyHoodCalculator;
import main.calculator.rating.NewsRatingCalculator;
import main.converter.CountryStatisticConverter;
import main.converter.GenderStatisticConverter;
import main.domain.statistic.CountryStatistic;
import main.domain.statistic.GenderStatistic;
import main.dto.rating.NewsRatingsDto;
import main.dto.request.LikelyHoodRequestDto;
import main.dto.response.RatingResponseDto;
import main.dto.statistic.NewsCountryStatisticsDto;
import main.dto.statistic.NewsGenderStatisticsDto;
import main.service.CountryStatisticService;
import main.service.GenderStatisticService;
import main.statistics.strategy.StatisticStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.List;

/**
 * Created by Titus on 12/11/2017.
 */

@RestController
public class NewsRatingController {

    private final NewsRatingCalculator newsRatingCalculator;

    private final GenderStatisticService genderStatisticService;

    private final CountryStatisticService countryStatisticService;

    private final LikelyHoodCalculator likelyHoodCalculator;

    @Autowired
    public NewsRatingController(NewsRatingCalculator newsRatingCalculator,
                                GenderStatisticService genderStatisticService,
                                CountryStatisticService countryStatisticService
                                    ,LikelyHoodCalculator likelyHoodCalculator) {
        this.newsRatingCalculator = newsRatingCalculator;
        this.genderStatisticService = genderStatisticService;
        this.countryStatisticService = countryStatisticService;
        this.likelyHoodCalculator = likelyHoodCalculator;
    }


    @RequestMapping(value = "/rating", method = RequestMethod.POST)
    public RatingResponseDto evaluateRating(@RequestBody
                                                    NewsRatingsDto newsRatingsDto){

        NewsCountryStatisticsDto newsCountryStatisticsDto= newsRatingCalculator.calculateCountryStatistics(newsRatingsDto);
        NewsGenderStatisticsDto newsGenderStatisticsDto = newsRatingCalculator.calculateGenderStatistics(newsRatingsDto);

        List<GenderStatistic> genderStatisticList = GenderStatisticConverter.convertFromDto(newsGenderStatisticsDto);
        List<CountryStatistic> countryStatisticList = CountryStatisticConverter.convertFromDto(newsCountryStatisticsDto);

        genderStatisticList
                .forEach(genderStatisticService::addGenderStatistic);

        countryStatisticList
                .forEach(countryStatisticService::addCountryStatistic);

        return RatingResponseDto
                .builder()
                .newsCountryStatisticsDto(newsCountryStatisticsDto)
                .newsGenderStatisticsDto(newsGenderStatisticsDto)
                .build();
    }

    @RequestMapping(value = "/likely", method = RequestMethod.POST)
    public double calculateLikelyHood(@RequestBody
                                      LikelyHoodRequestDto likelyHoodRequestDto){
        System.out.println(likelyHoodRequestDto);
        return this.likelyHoodCalculator.executeStrategy(likelyHoodRequestDto);
    }
}
