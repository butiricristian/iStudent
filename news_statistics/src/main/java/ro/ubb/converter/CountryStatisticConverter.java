package ro.ubb.converter;

import ro.ubb.domain.enum_model.Country;
import ro.ubb.domain.statistic.CountryStatistic;
import ro.ubb.dto.statistic.NewsCountryStatisticsDto;

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
