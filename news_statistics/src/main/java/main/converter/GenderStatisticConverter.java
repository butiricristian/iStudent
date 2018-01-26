package main.converter;

import main.domain.enum_model.Gender;
import main.domain.statistic.GenderStatistic;
import main.dto.statistic.NewsGenderStatisticsDto;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class GenderStatisticConverter {
    public static List<GenderStatistic> convertFromDto(NewsGenderStatisticsDto newsGenderStatisticsDto){
        List<GenderStatistic> genderStatistics = new ArrayList<>();
        Map<String, String> genderStatisticDtoList = newsGenderStatisticsDto.getGenderFavoriteHashtag();
        genderStatisticDtoList
                .forEach((key, value) -> genderStatistics.add(new GenderStatistic(Gender.valueOf(key), value)));

        return genderStatistics;
    }
}
