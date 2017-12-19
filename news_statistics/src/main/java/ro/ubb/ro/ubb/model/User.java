package ro.ubb.ro.ubb.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import ro.ubb.ro.ubb.model.ro.ubb.model.enums.Country;
import ro.ubb.ro.ubb.model.ro.ubb.model.enums.Gender;

@Document(collection = "user")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class User {
    @Id
    private Long id;
    private String name;
    private int age;
    private Country country;
    private Gender gender;
}
