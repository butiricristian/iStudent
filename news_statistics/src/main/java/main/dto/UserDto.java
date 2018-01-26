package main.dto;

import lombok.*;
import main.domain.enum_model.Country;
import main.domain.enum_model.Gender;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class UserDto {
    private Long id;
    private String name;
    private int age;
    private Country country;
    private Gender gender;
}
