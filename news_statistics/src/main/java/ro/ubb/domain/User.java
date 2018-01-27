package ro.ubb.domain;

import ro.ubb.domain.enum_model.Country;
import ro.ubb.domain.enum_model.Gender;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created by Titus on 12/11/2017.
 */
@Document(collection = "user")

public class User {
    @Id
    private Long id;
    private String name;
    private int age;
    private Country country;
    private Gender gender;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", country=" + country +
                ", gender=" + gender +
                '}';
    }

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

    public User() {

    }

    public User(Long id, String name, int age, Country country, Gender gender) {

        this.id = id;
        this.name = name;
        this.age = age;
        this.country = country;
        this.gender = gender;
    }
}
