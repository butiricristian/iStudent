package ro.ubb.dto.response;
import lombok.Builder;
import ro.ubb.dto.statistic.NewsCountryStatisticsDto;
import ro.ubb.dto.statistic.NewsGenderStatisticsDto;
@Builder
public class RatingResponseDto {
    private NewsGenderStatisticsDto newsGenderStatisticsDto;
    private NewsCountryStatisticsDto newsCountryStatisticsDto;

    public NewsGenderStatisticsDto getNewsGenderStatisticsDto() {
        return newsGenderStatisticsDto;
    }

    public void setNewsGenderStatisticsDto(NewsGenderStatisticsDto newsGenderStatisticsDto) {
        this.newsGenderStatisticsDto = newsGenderStatisticsDto;
    }

    public NewsCountryStatisticsDto getNewsCountryStatisticsDto() {
        return newsCountryStatisticsDto;
    }

    public void setNewsCountryStatisticsDto(NewsCountryStatisticsDto newsCountryStatisticsDto) {
        this.newsCountryStatisticsDto = newsCountryStatisticsDto;
    }

    public RatingResponseDto() {

    }

    public RatingResponseDto(NewsGenderStatisticsDto newsGenderStatisticsDto, NewsCountryStatisticsDto newsCountryStatisticsDto) {

        this.newsGenderStatisticsDto = newsGenderStatisticsDto;
        this.newsCountryStatisticsDto = newsCountryStatisticsDto;
    }
}
