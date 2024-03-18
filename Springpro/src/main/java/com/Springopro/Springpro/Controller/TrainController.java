package com.Springopro.Springpro.Controller;

import com.Springopro.Springpro.Entity.Train;
import com.Springopro.Springpro.Entity.User;
import com.Springopro.Springpro.Service.TrainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController

public class TrainController {
    @Autowired
    private TrainService trainService;

    @PostMapping(value = "/addTrain")
    public Train postDetails(@RequestBody Train train) {
        return trainService.saveDetails(train);

    }

    @DeleteMapping("/deleteTrain/{id}")
    public void deleteTrain(@PathVariable int id) {
        trainService.deleteTrainById(id);
    }

    @PutMapping("/updateTrain/{id}")
    public Train updateTrain(@RequestBody Train train,
                             @PathVariable int id) {
        return trainService.updateTrain(train,id);
    }

    @GetMapping("/allTrain")
    public List<Train> getAllTrains() {
        return trainService.getAllTrains();
    }

    @GetMapping("/getTrain/{id}")
    public Train getTrainById(@PathVariable int id) {
        return trainService.getTrainById(id);
    }


}
