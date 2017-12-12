package main.dto;

import lombok.*;
import org.springframework.data.annotation.Id;

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
