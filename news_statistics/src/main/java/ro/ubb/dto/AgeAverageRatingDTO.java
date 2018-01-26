package ro.ubb.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import ro.ubb.model.annotations.MyObject;

@MyObject
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class AgeAverageRatingDTO {
    public Integer age; //made public only to test reflection
    public Double rating;
}
