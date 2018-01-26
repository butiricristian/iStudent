package main.dto.rating;

import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class NewsRatingsDto {
    private List<NewsRatingDto> newsRatingDtoList;
}
