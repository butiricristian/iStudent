package main.dto;
import lombok.*;
import main.domain.Country;
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
