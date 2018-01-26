package main.domain.statistic;

import lombok.*;
import main.domain.enum_model.Country;
import org.springframework.data.mongodb.core.mapping.Document;
@ToString
@Document(collection = "country_statistic")
public class CountryStatistic {
    private Country country;
    private String hashTag;

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public String getHashTag() {
        return hashTag;
    }

    public void setHashTag(String hashTag) {
        this.hashTag = hashTag;
    }

    public CountryStatistic() {

    }

    public CountryStatistic(Country country, String hashTag) {

        this.country = country;
        this.hashTag = hashTag;
    }
}
