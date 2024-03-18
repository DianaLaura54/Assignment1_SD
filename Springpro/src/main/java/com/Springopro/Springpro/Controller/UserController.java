package com.Springopro.Springpro.Controller;

import com.Springopro.Springpro.Entity.Train;
import com.Springopro.Springpro.Entity.User;
import com.Springopro.Springpro.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController

public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping(value = "/addUser")
    public User postDetails(@RequestBody User user) {
        return userService.saveDetails(user);

    }

    @DeleteMapping("/deleteUser/{id}")
    public void deleteUser(@PathVariable int id) {
        userService.deleteUserById(id);
    }

    @PutMapping("/updateUser/{id}")
    public User updateUser(@RequestBody User user,
                           @PathVariable int id) {
        return userService.updateUser(user,id);
    }

    @GetMapping("/allUser")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/getUser/{id}")
    public User getUserById(@PathVariable int id) {
        return userService.getUserById(id);
    }


}
