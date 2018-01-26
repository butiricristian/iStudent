package main.dto.statistic;
import lombok.*;

import java.util.Map;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class NewsCountryStatisticsDto {
    private Map<String,String> countryFavoriteHashtag;
}
