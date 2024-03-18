package com.Springopro.Springpro.Service;

import com.Springopro.Springpro.Entity.Train;
import com.Springopro.Springpro.Entity.User;
import com.Springopro.Springpro.Repository.TrainRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class TrainService {
    @Autowired
    private TrainRepo trainRepo;

    public Train saveDetails(Train train) {
        return trainRepo.save(train);
    }

    @Transactional
    public void deleteTrainById(int id) {
        Train train = trainRepo.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Train not found with id: " + id));

        trainRepo.deleteById(id);
    }

    @Transactional
    public Train updateTrain(Train updatedTrain, int id) {
        Train existingTrain = trainRepo.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Train not found with id: " + id));

        if (existingTrain != null) {
            // Update only the fields provided in updatedTrain
            if (updatedTrain.getNr_seats() != 0) {
                existingTrain.setNr_seats(updatedTrain.getNr_seats());
            }
            if (updatedTrain.getPrice_ticket() !=0) {
                existingTrain.setPrice_ticket(updatedTrain.getPrice_ticket());
            }
            if (updatedTrain.getDeparture_time() != null) {
                existingTrain.setDeparture_time(updatedTrain.getDeparture_time());
            }
            if (updatedTrain.getArrival_time() != null) {
                existingTrain.setArrival_time(updatedTrain.getArrival_time());
            }
            if (updatedTrain.getMonth() != 0) {
                existingTrain.setMonth(updatedTrain.getMonth());
            }
            if (updatedTrain.getDay() != 0) {
                existingTrain.setDay(updatedTrain.getDay());
            }
        } else {
            throw new IllegalArgumentException("Train not found with id: " + id);
        }

        return trainRepo.save(existingTrain);
    }

    public List<Train> getAllTrains() {
        return trainRepo.findAll();
    }

    public Train getTrainById(int id) {
        Optional<Train> trainOptional = trainRepo.findById(id);
        return trainOptional.orElse(null);
    }


}