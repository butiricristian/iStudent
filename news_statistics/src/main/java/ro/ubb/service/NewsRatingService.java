package ro.ubb.service;

import ro.ubb.repository.NewsRatingRepository;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Titus on 12/11/2017.
 */
public class NewsRatingService {
    @Autowired
    private NewsRatingRepository newsRatingRepository;
}