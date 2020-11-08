package com.adakapital.adakapitalbackendcase.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Data
@Document(collection = "USER")
public class User {

    @Id
    private String id;

    private String name;

    @JsonFormat(pattern="yyyy-MM-dd")
    private LocalDate dateOfBirth;

    private Adress adress;
    private String description;
    private String createdAd;
    private String email;
    private String updatedAt;
    
    private static User instance;
    
    public static synchronized User getInstance(){
        if(instance == null)
            instance = new User();
        return instance;
    }

}
