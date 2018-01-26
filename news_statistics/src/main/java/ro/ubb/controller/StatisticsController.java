package ro.ubb.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ro.ubb.dto.AgeAverageRatingDTO;
import ro.ubb.service.StatisticsService;

import java.util.List;

@RestController
public class StatisticsController {

    @Autowired
    StatisticsService statisticsService;

    @GetMapping("/statistics/news/youngerThan")
    public String statisticsFromStudentsYoungerThan() {
        List<AgeAverageRatingDTO> statistics = statisticsService.statisticsFromStudentsYoungerThan(30);

        return getJSON(statistics);
    }

    @GetMapping("/statistics/news/olderThan")
    public String statisticsFromStudentsOlderThan() {
        List<AgeAverageRatingDTO> statistics = statisticsService.statisticsFromStudentsOlderThan(17);

        return getJSON(statistics);
    }

    @GetMapping("/statistics/news/ageBetween")
    public String statisticsFromStudentsAgedBetween() {
        List<AgeAverageRatingDTO> statistics = statisticsService.statisticsFromStudentsAgedBetween(19, 26);

        return getJSON(statistics);
    }


    private String getJSON(List<AgeAverageRatingDTO> statistics) {
        String json = null;
        try {
            json = new ObjectMapper().writeValueAsString(statistics);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return json;
    }
}