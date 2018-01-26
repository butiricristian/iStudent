package ro.ubb.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@Document(collection = "newsrating")
@Getter
@Setter
@ToString
public class NewsRating extends Rating<News> implements Serializable {
    public NewsRating() {
        super();
    }
}
