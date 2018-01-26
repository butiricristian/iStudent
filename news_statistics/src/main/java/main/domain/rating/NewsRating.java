package main.domain.rating;

import lombok.*;
import main.domain.News;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created by Titus on 12/11/2017.
 */
@Document(collection = "newsrating")
@Getter
@Setter
@ToString
public class NewsRating extends Rating<News> {
    public NewsRating() {
        super();
    }
}
