package ro.ubb.domain.rating;
import ro.ubb.domain.News;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created by Titus on 12/11/2017.
 */
@Document(collection = "newsrating")
public class NewsRating extends Rating<News> {
    public NewsRating() {
        super();
    }
}
