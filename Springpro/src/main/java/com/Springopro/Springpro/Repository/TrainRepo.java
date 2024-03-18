package com.Springopro.Springpro.Repository;

import com.Springopro.Springpro.Entity.Train;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TrainRepo extends JpaRepository<Train, Integer> {
}