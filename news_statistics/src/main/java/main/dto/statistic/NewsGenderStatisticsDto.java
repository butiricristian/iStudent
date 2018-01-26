package main.dto.statistic;

import lombok.*;

import java.util.Map;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class NewsGenderStatisticsDto {
    private Map<String,String> genderFavoriteHashtag;
}
