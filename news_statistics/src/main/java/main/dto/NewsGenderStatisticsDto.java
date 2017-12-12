package main.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class NewsGenderStatisticsDto {
    private Long likesFromWomen;
    private Long likesFromMen;
}
