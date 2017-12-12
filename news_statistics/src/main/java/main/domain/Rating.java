package main.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;

/**
 * Created by Titus on 12/11/2017.
 */

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public abstract class Rating<T>{

    @Id
    private Long id;
    private T subject;
    private User user;
    private Double score;
}
