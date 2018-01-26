package main.domain.statistic;

import lombok.*;
import main.domain.enum_model.Gender;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "gender_statistic")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class GenderStatistic {
    private Gender gender;
    private String hashTag;
}
