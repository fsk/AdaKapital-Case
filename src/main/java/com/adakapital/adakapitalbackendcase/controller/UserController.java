package com.adakapital.adakapitalbackendcase.controller;

import com.adakapital.adakapitalbackendcase.models.User;
import com.adakapital.adakapitalbackendcase.repositories.UserRepository;
import com.adakapital.adakapitalbackendcase.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/adakapital")
public class UserController {


    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/insertuser")
    public String addUser(@RequestBody User user){
        try{
            userService.insertUser(user);
            return "User was insert successfully.";
        }catch (Exception e){
            return "ERROR.!" + " " + e.getMessage();
        }
    }

    @GetMapping("/getbyid/{id}")
    public Optional<User> getUserById(@PathVariable("id") String id){
        return userService.getUserById(id);
    }

    @GetMapping("/getallusers")
    public ArrayList<User> getAllUsers(){
        return userService.getAllUsers();
    }

    @DeleteMapping("/deletebyid/{id}")
    public String deleteById(@PathVariable("id") String id){
        try {
            userService.deleteById(id);
            return "User was delete successfully";
        }catch (Exception e){
            return "ERROR.!" + " " + e.getMessage();
        }
    }

    @DeleteMapping("/deleteall")
    public String deleteAll(){
        try {
            userService.deleteAll();
            return "Delete all users.!";
        }catch (Exception e){
            return "ERROR.!" + " " + e.getMessage();
        }
    }

    @PutMapping("/updatebyid/{id}")
    public Optional<User> updateById(@PathVariable("id") String id, @RequestBody User user){
        return userService.updateUserById(id, user);
    }
}
