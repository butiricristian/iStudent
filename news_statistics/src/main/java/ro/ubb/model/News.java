package ro.ubb.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.List;

@Document(collection = "news")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class News implements Serializable {
    @Id
    private Long id;
    private String content;
    private List<String> hashTags;

}
