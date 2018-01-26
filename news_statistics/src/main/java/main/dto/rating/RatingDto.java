package main.dto.rating;

import main.dto.UserDto;

/**
 * Created by Titus on 12/12/2017.
 */
public abstract class RatingDto<T>{
    private Long id;
    private T subject;
    private UserDto user;
    private Double score;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public T getSubject() {
        return subject;
    }

    public void setSubject(T subject) {
        this.subject = subject;
    }

    public UserDto getUser() {
        return user;
    }

    public void setUser(UserDto user) {
        this.user = user;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }
}
