package main.dto;

import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class NewsDto {
    private Long Id;
    private String content;
    private List<String> hashTags;
}
