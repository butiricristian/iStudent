package main.dto.response;
import lombok.*;
import main.dto.statistic.NewsCountryStatisticsDto;
import main.dto.statistic.NewsGenderStatisticsDto;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class RatingResponseDto {
    private NewsGenderStatisticsDto newsGenderStatisticsDto;
    private NewsCountryStatisticsDto newsCountryStatisticsDto;
}
