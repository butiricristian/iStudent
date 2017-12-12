package main.dto;

import lombok.*;
import main.domain.NewsRating;
import ro.ubb.istudent.dto.Dto;

/**
 * Created by Titus on 12/12/2017.
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class NewsRatingDto extends RatingDto<NewsDto> {
}
