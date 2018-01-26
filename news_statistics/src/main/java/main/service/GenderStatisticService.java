package main.service;
import main.domain.statistic.GenderStatistic;
import main.repository.GenderStatisticRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class GenderStatisticService {

    @Autowired
    private GenderStatisticRepository genderStatisticRepository;

    public void addGenderStatistic(GenderStatistic genderStatistic){

        System.out.println("Saving Gender statistic");
        genderStatisticRepository.save(genderStatistic);
    }

    public Optional<List<GenderStatistic>> findAll(){
        return Optional.of(genderStatisticRepository.findAll());
    }
}
