package ro.ubb.dto.rating;
import java.util.List;

public class NewsRatingsDto {
    private List<NewsRatingDto> newsRatingDtoList;

    public List<NewsRatingDto> getNewsRatingDtoList() {
        return newsRatingDtoList;
    }

    public void setNewsRatingDtoList(List<NewsRatingDto> newsRatingDtoList) {
        this.newsRatingDtoList = newsRatingDtoList;
    }

    public NewsRatingsDto() {

    }

    public NewsRatingsDto(List<NewsRatingDto> newsRatingDtoList) {

        this.newsRatingDtoList = newsRatingDtoList;
    }
}
