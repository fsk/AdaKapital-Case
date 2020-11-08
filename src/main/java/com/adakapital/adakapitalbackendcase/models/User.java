package com.adakapital.adakapitalbackendcase.models;

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
    private LocalDateTime dateOfBirth;
    private Adress adress;
    private String description;
    private String createdAd;
    private String email;
    private String updateAt;

}
