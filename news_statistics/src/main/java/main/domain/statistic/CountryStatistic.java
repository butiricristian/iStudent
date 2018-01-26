package main.domain.statistic;

import lombok.*;
import main.domain.enum_model.Country;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "country_statistic")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CountryStatistic {
    private Country country;
    private String hashTag;
}
