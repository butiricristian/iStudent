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
public class News implements Serializable{
    @Id
    private Long Id;

    private String content;

    private List<String> hashTags;

    @Override
    public String toString() {
        return "News{" +
                "Id=" + Id +
                ", content='" + content + '\'' +
                ", hashTags=" + hashTags +
                '}';
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public List<String> getHashTags() {
        return hashTags;
    }

    public void setHashTags(List<String> hashTags) {
        this.hashTags = hashTags;
    }

    public News(Long id, String content, List<String> hashTags) {

        Id = id;
        this.content = content;
        this.hashTags = hashTags;
    }

    public News() {

    }
}
