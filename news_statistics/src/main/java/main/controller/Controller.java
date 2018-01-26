package main.controller;

import main.domain.DummyClass;
import main.repository.DummyRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
//Left this here for compatibility purpose - Titus(thanks Sergiu!)
@RestController
public class Controller {
    @Autowired
    DummyRepo dummyRepo;

    public Controller(){
    }


    @GetMapping("/")
    public String fuckYou(){
        dummyRepo.save(new DummyClass(1L, "Dummy1"));
        return dummyRepo.findOne(1L).toString();
    }
}
