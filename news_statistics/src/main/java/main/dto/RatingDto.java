package main.dto;

import lombok.*;
import main.domain.Rating;
import main.domain.User;
import org.springframework.data.annotation.Id;
import ro.ubb.istudent.dto.Dto;

/**
 * Created by Titus on 12/12/2017.
 */
@Getter
@Setter
public abstract class RatingDto<T> implements Dto {
    private Long id;
    private T subject;
    private UserDto user;
    private Double score;
}
