package main.domain;


import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Titus on 12/11/2017.
 */
@Document(collection = "news")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class News implements Serializable{
    @Id
    private Long Id;

    private String content;

    private List<String> hashTags;

}
