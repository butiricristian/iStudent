package ro.ubb.rest;

import ro.ubb.dto.rating.NewsRatingsDto;
import ro.ubb.dto.statistic.NewsCountryStatisticsDto;
import ro.ubb.calculator.rating.LikelyHoodCalculator;
import ro.ubb.calculator.rating.NewsRatingCalculator;
import ro.ubb.converter.CountryStatisticConverter;
import ro.ubb.converter.GenderStatisticConverter;
import ro.ubb.domain.statistic.CountryStatistic;
import ro.ubb.domain.statistic.GenderStatistic;
import ro.ubb.dto.request.LikelyHoodRequestDto;
import ro.ubb.dto.response.RatingResponseDto;
import ro.ubb.dto.statistic.NewsGenderStatisticsDto;
import ro.ubb.service.CountryStatisticService;
import ro.ubb.service.GenderStatisticService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
