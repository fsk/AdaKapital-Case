package com.adakapital.adakapitalbackendcase.controller;

import com.adakapital.adakapitalbackendcase.apipath.UsersPath;
import com.adakapital.adakapitalbackendcase.messages.errormessages.UserErrorMessages;
import com.adakapital.adakapitalbackendcase.messages.successmessages.UserSuccessMessages;
import com.adakapital.adakapitalbackendcase.models.User;
import com.adakapital.adakapitalbackendcase.repositories.UserRepository;
import com.adakapital.adakapitalbackendcase.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = UsersPath.BASE_URL)
public class UserController {


    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping(value = UsersPath.INSERT_USER)
    public String addUser(@RequestBody User user){
        try{
            userService.insertUser(user);
            return UserSuccessMessages.INSERT_MESSAGE;
        }catch (Exception e){
            return  UserErrorMessages.INSERT_ERROR + "\n"+
                    UserErrorMessages.SYSTEM_CAUSE_MESSAGE + e.getCause() + "\n"+
                    UserErrorMessages.SYSTEM_ERROR_MESSAGE + e.getMessage();
        }
    }

    @GetMapping(value = UsersPath.GET_BY_ID + "{id}")
    public Optional<User> getUserById(@PathVariable("id") String id){
        return userService.getUserById(id);
    }

    @GetMapping(value = UsersPath.GET_ALL_USERS)
    public ArrayList<User> getAllUsers(){
        return userService.getAllUsers();
    }

    @DeleteMapping(value = UsersPath.DELETE_BY_ID + "{id}")
    public String deleteById(@PathVariable("id") String id){
        try {
            userService.deleteById(id);
            return UserSuccessMessages.DELETE_BY_ID_MESSAGE;
        }catch (Exception e){
            return  UserErrorMessages.DELETE_BY_ID_ERROR + "\n" +
                    UserErrorMessages.SYSTEM_CAUSE_MESSAGE + e.getCause() +
                    UserErrorMessages.SYSTEM_ERROR_MESSAGE + e.getMessage();
        }
    }

    @DeleteMapping(value = UsersPath.DELETE_ALL_USERS)
    public String deleteAll(){
        try {
            userService.deleteAll();
            return UserSuccessMessages.DELETE_ALL_MESSAGE;
        }catch (Exception e){
            return  UserErrorMessages.DELETE_ALL_USERS_ERROR + "\n" +
                    UserErrorMessages.SYSTEM_CAUSE_MESSAGE + e.getCause() +
                    UserErrorMessages.SYSTEM_ERROR_MESSAGE + e.getMessage();
        }
    }

    @PutMapping(value = UsersPath.UPDATE_BY_ID + "{id}")
    public Optional<User> updateById(@PathVariable("id") String id, @RequestBody User user){
        return userService.updateUserById(id, user);
    }
}
