package ro.ubb.converter;

import ro.ubb.domain.enum_model.Gender;
import ro.ubb.domain.statistic.GenderStatistic;
import ro.ubb.dto.statistic.NewsGenderStatisticsDto;

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
