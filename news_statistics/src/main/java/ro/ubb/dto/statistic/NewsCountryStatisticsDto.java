package ro.ubb.dto.statistic;

import java.util.Map;

public class NewsCountryStatisticsDto {
    public Map<String, String> getCountryFavoriteHashtag() {
        return countryFavoriteHashtag;
    }

    public void setCountryFavoriteHashtag(Map<String, String> countryFavoriteHashtag) {
        this.countryFavoriteHashtag = countryFavoriteHashtag;
    }

    public NewsCountryStatisticsDto() {

    }

    public NewsCountryStatisticsDto(Map<String, String> countryFavoriteHashtag) {

        this.countryFavoriteHashtag = countryFavoriteHashtag;
    }

    private Map<String,String> countryFavoriteHashtag;
}
