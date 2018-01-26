package main.dto.statistic;


import java.util.Map;

public class NewsGenderStatisticsDto {
    private Map<String,String> genderFavoriteHashtag;

    public Map<String, String> getGenderFavoriteHashtag() {
        return genderFavoriteHashtag;
    }

    public void setGenderFavoriteHashtag(Map<String, String> genderFavoriteHashtag) {
        this.genderFavoriteHashtag = genderFavoriteHashtag;
    }

    public NewsGenderStatisticsDto() {

    }

    public NewsGenderStatisticsDto(Map<String, String> genderFavoriteHashtag) {

        this.genderFavoriteHashtag = genderFavoriteHashtag;
    }
}
