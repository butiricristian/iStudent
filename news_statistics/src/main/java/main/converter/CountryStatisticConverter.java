package main.converter;

import main.domain.enum_model.Country;
import main.domain.statistic.CountryStatistic;
import main.dto.statistic.NewsCountryStatisticsDto;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CountryStatisticConverter {
    public static List<CountryStatistic> convertFromDto(NewsCountryStatisticsDto newsCountryStatisticsDto){
        List<CountryStatistic> countryStatistics = new ArrayList<>();
        Map<String, String> countryStatisticDtoList = newsCountryStatisticsDto.getCountryFavoriteHashtag();
        countryStatisticDtoList
                .forEach((key, value) -> countryStatistics.add(new CountryStatistic(Country.valueOf(key), value)));

        return countryStatistics;
    }
}
