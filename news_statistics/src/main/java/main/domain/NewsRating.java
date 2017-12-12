package main.domain;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created by Titus on 12/11/2017.
 */
@Document(collection = "newsrating")
@Getter
@Setter
@ToString
public class NewsRating extends Rating<News>{
    public NewsRating() {
        super();
    }
}
