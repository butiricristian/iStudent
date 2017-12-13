package main.dto;
import lombok.*;

/**
 * Created by Titus on 12/12/2017.
 */
@Getter
@Setter
@AllArgsConstructor
@ToString
@Builder
public class NewsRatingDto extends RatingDto<NewsDto> {
}
