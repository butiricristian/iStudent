package ro.ubb.ro.ubb.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "newsrating")
@Getter
@Setter
@ToString
public class NewsRating extends Rating<News> {
    public NewsRating() {
        super();
    }
}
