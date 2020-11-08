package com.adakapital.adakapitalbackendcase.service;

import com.adakapital.adakapitalbackendcase.models.User;
import com.adakapital.adakapitalbackendcase.repositories.UserRepository;
import org.springframework.stereotype.Service;


import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void insertUser(User user) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        LocalDateTime date = LocalDateTime.now();
        user.setCreatedAd(date.format(formatter));
        userRepository.insert(user);
    }

    public Optional<User> getUserById(String id) {
        return userRepository.findById(id);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public void deleteById(String id) {
        Optional<User> user = getUserById(id);
        user.ifPresent(item -> userRepository.deleteById(id));

    }

    public void deleteAll() {
        userRepository.deleteAll();
    }

    public Optional<User> updateUserById(String id, User updateUser) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        LocalDateTime date = LocalDateTime.now();
        Optional<User> user = getUserById(id);
        if (updateUser != null){
                user.ifPresent(item -> item.setName(updateUser.getName()));
                user.ifPresent(item -> item.setDateOfBirth(updateUser.getDateOfBirth()));
                user.ifPresent(item -> item.setAdress(updateUser.getAdress()));
                user.ifPresent(item -> item.setDescription(updateUser.getDescription()));
                user.ifPresent(item -> item.setCreatedAd(updateUser.getCreatedAd()));
                updateUser.setUpdateAt(date.format(formatter));
                user.ifPresent(item -> userRepository.save(item));
        }
        return user;
    }
}
