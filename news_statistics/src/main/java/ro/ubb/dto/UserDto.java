package ro.ubb.dto;

import ro.ubb.domain.enum_model.Country;
import ro.ubb.domain.enum_model.Gender;

public class UserDto {
    private Long id;
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public UserDto() {

    }

    public UserDto(Long id, String name, int age, Country country, Gender gender) {

        this.id = id;
        this.name = name;
        this.age = age;
        this.country = country;
        this.gender = gender;
    }

    private int age;
    private Country country;
    private Gender gender;
}
