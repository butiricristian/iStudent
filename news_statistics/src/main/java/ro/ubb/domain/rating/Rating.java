package ro.ubb.domain.rating;

import ro.ubb.domain.User;
import org.springframework.data.annotation.Id;

/**
 * Created by Titus on 12/11/2017.
 */

public abstract class Rating<T>{

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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    public Rating() {

    }

    public Rating(Long id, T subject, User user, Double score) {

        this.id = id;
        this.subject = subject;
        this.user = user;
        this.score = score;
    }

    @Id
    private Long id;
    private T subject;
    private User user;
    private Double score;
}
