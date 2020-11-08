package com.adakapital.adakapitalbackendcase.service;

import com.adakapital.adakapitalbackendcase.messages.errormessages.UserErrorMessages;
import com.adakapital.adakapitalbackendcase.messages.successmessages.UserSuccessMessages;
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

    public void insertUser(User user) throws Exception {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        LocalDateTime date = LocalDateTime.now();
        user.setCreatedAd(date.format(formatter));
        if (!user.getEmail().contains("@")) {
            throw new Exception(UserErrorMessages.INVALID_EMAIL);
        } else if (user.getEmail() != null) {
            String email = userRepository.findByEmailLike(user.getEmail());
            if (email != null) {
                throw new Exception(UserErrorMessages.EMAIL_ALREADY_EXISTS);
            }
        }
        userRepository.insert(user);
    }

    public Optional<User> getUserById(String id) throws Exception {
        Optional<User> user = userRepository.findById(id);
        if (user != null && !user.isEmpty()) {
            return user;
        } else {
            throw new Exception(UserErrorMessages.USER_NOT_FOUND);
        }
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public void deleteById(String id) throws Exception {
        Optional<User> user = getUserById(id);
        user.ifPresent(item -> userRepository.deleteById(id));

    }

    public void deleteAll() {
        userRepository.deleteAll();
    }

    public String updateUserById(String id, User updateUser) throws Exception {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        LocalDateTime date = LocalDateTime.now();
        //User user = new User();
        //Optional<User> user = getUserById(id);
        try {
            Optional<User> userForUpdate = userRepository.findById(id);
            if (!userForUpdate.isEmpty()) {

                if (updateUser.getCreatedAd() != null) {
                    throw new Exception(UserErrorMessages.CREATED_TIME_NOT_CHANGE);
                }

                if (updateUser.getName() != null) {
                    userForUpdate.ifPresent(item->item.setName(updateUser.getName()));
                }
                
                if(updateUser.getDateOfBirth() != null) {
                    userForUpdate.ifPresent(item -> item.setDateOfBirth(updateUser.getDateOfBirth()));
                }
                
                if(updateUser.getAdress() != null){
                    userForUpdate.ifPresent(item -> item.setAdress(updateUser.getAdress()));
                }
                
                if(updateUser.getDescription() != null){
                    userForUpdate.ifPresent(item -> item.setDescription(updateUser.getDescription()));
                }
                
                if(updateUser.getEmail() != null){
                    userForUpdate.ifPresent(item -> item.setEmail(updateUser.getEmail()));
                }
                
                userForUpdate.ifPresent(item -> item.setUpdatedAt(date.format(formatter)));
                
                userForUpdate.ifPresent(item -> userRepository.save(item));
                
                return UserSuccessMessages.UPDATE_BY_ID_SUCCESS_MESSAGE;

            } else {
                throw new Exception(UserErrorMessages.USER_NOT_FOUND);
            }

        } catch (Exception e) {
            return UserErrorMessages.UPDATE_BY_ID_ERROR_MESSAGE + "\n"
                    + UserErrorMessages.SYSTEM_CAUSE_MESSAGE + e.getCause() + "\n"
                    + UserErrorMessages.SYSTEM_ERROR_MESSAGE + e.getMessage();
        }
    }
}
