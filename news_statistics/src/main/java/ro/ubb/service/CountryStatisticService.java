package ro.ubb.service;

import ro.ubb.repository.CountryStatisticsRepository;
import ro.ubb.domain.statistic.CountryStatistic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CountryStatisticService {
    @Autowired
    private CountryStatisticsRepository countryStatisticsRepository;

    public void addCountryStatistic(CountryStatistic countryStatistic){
        System.out.println("Saving COuntry statistic");
        countryStatisticsRepository.save(countryStatistic);
    }

    public Optional<List<CountryStatistic>> findAll(){
        return Optional.of(countryStatisticsRepository.findAll());
    }
}
