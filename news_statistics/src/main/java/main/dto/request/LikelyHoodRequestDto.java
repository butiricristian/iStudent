package main.dto.request;

import lombok.*;
import main.dto.NewsDto;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class LikelyHoodRequestDto {
    private boolean country;
    private boolean gender;
    private NewsDto newsDto;
}
