package ro.ubb.dto;

import java.util.List;

public class NewsDto {
    private Long Id;
    private String content;

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

    public NewsDto() {

    }

    public NewsDto(Long id, String content, List<String> hashTags) {

        Id = id;
        this.content = content;
        this.hashTags = hashTags;
    }

    private List<String> hashTags;
}
