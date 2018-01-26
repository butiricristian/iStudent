package main.domain.statistic;

import lombok.*;
import main.domain.enum_model.Gender;
import org.springframework.data.mongodb.core.mapping.Document;
@ToString
@Document(collection = "gender_statistic")
public class GenderStatistic {
    private Gender gender;
    private String hashTag;

    public GenderStatistic() {
    }

    public GenderStatistic(Gender gender, String hashTag) {

        this.gender = gender;
        this.hashTag = hashTag;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getHashTag() {
        return hashTag;
    }

    public void setHashTag(String hashTag) {
        this.hashTag = hashTag;
    }
}
