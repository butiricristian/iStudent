package ro.ubb.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ro.ubb.model.annotations.MyObject;

@MyObject
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AgeAverageRating {
    public Integer age;  //made public only to test reflection
    public Double rating;
}
