package com.Springopro.Springpro.Service;

import com.Springopro.Springpro.Entity.User;
import com.Springopro.Springpro.Repository.UserRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepo userRepo;

    public User saveDetails(User user) {
        return userRepo.save(user);
    }
    public void saveUser(User user) {
        userRepo.save(user);
    }

    @Transactional
    public void deleteUserById(int id) {
        User user = userRepo.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("User is not found with id: " + id));

        user.getTrain().getUsersList().remove(user);


        userRepo.delete(user);
    }

    @Transactional
    public User updateUser(User updatedUser,int userId) {
        User existingUser = userRepo.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("User not found with id: " + userId));

        if (existingUser != null) {
            if (updatedUser.getName() != null) {
                existingUser.setName(updatedUser.getName());
            }
            if (updatedUser.getId_seat() != 0) {
                existingUser.setId_seat(updatedUser.getId_seat());
            }
            if (updatedUser.getId_train() != 0) {
                existingUser.setId_train(updatedUser.getId_train());
            }
            existingUser.setStudent(updatedUser.isStudent());
        } else {
            throw new IllegalArgumentException("User not found with id: " + userId);
        }

        return userRepo.save(existingUser);
    }

    public List<User> getAllUsers() {
        return userRepo.findAll();
    }

    public User getUserById(int id) {
        Optional<User> userOptional = userRepo.findById(id);
        return userOptional.orElse(null);
    }



}
