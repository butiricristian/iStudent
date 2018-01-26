package main.rating;

import main.domain.statistic.CountryStatistic;
import main.domain.statistic.GenderStatistic;
import main.dto.request.LikelyHoodRequestDto;
import main.service.CountryStatisticService;
import main.service.GenderStatisticService;

import main.strategy.CountryStrategy;
import main.strategy.GenderStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class LikelyHoodCalculator {
    private final GenderStatisticService genderStatisticService;

    private final CountryStatisticService countryStatisticService;

    @Autowired
    public LikelyHoodCalculator(GenderStatisticService genderStatisticService, CountryStatisticService countryStatisticService) {
        this.genderStatisticService = genderStatisticService;
        this.countryStatisticService = countryStatisticService;
    }


    public long executeStrategy(LikelyHoodRequestDto likelyHoodRequestDto){
        double res = 0;
        int strategy_no =0 ;
        if(likelyHoodRequestDto.isGender()){
            Optional<List<GenderStatistic>> genderStatisticsOptional = genderStatisticService.findAll();
            if(genderStatisticsOptional.isPresent()){
                res+= new GenderStrategy().calculateLikelyHood(likelyHoodRequestDto.getNewsDto(), genderStatisticsOptional.get());
                strategy_no++;
            }
        }
        if(likelyHoodRequestDto.isCountry()){
            Optional<List<CountryStatistic>> countryStatisticsOptional = countryStatisticService.findAll();
            if(countryStatisticsOptional.isPresent()){
                res+= new CountryStrategy().calculateLikelyHood(likelyHoodRequestDto.getNewsDto(), countryStatisticsOptional.get());
                strategy_no++;
            }
        }
        if(strategy_no >0){
            return (long)res*100/strategy_no;
        }
        else{
            return (long)res * 100;
        }
    }
}
