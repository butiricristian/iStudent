package ro.ubb.service.utils;

import ro.ubb.model.NewsRating;
import ro.ubb.model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Utils {

    public List<User> populateUsers() {
        List<User> students = new ArrayList<>();
        Random rnd = new Random();
        int lowNoStudents = 200, highNoStudents = 1000;
        int noOfStudents = rnd.nextInt(highNoStudents - lowNoStudents) + lowNoStudents;
        int lowAge = 17, highAge = 26;

        for (int i = 0; i < noOfStudents; i++) {
            User student = new User();
            student.setAge(rnd.nextInt(highAge - lowAge) + lowAge);
            students.add(student);
        }
        return students;
    }

    public List<NewsRating> populateNewsRating(List<User> students) {
        List<NewsRating> newsRatings = new ArrayList<>();
        Random rnd = new Random();
        int low = 500, high = 2000;
        int noOfRatings = rnd.nextInt(high - low) + low;

        for (int i = 0; i < noOfRatings; i++) {
            int studentIndex = rnd.nextInt(students.size() - 1);
            User student = students.get(studentIndex);
            NewsRating newsRating = new NewsRating();
            newsRating.setUser(student);
            newsRating.setScore(1 + (100 - 1) * rnd.nextDouble());
            newsRatings.add(newsRating);
        }
        return newsRatings;
    }

    public static double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();

        long factor = (long) Math.pow(10, places);
        value = value * factor;
        long tmp = Math.round(value);
        return (double) tmp / factor;
    }

}
