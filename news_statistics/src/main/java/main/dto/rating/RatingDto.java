package main.dto.rating;

import lombok.*;
import main.dto.UserDto;
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
