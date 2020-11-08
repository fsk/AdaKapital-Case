package com.adakapital.adakapitalbackendcase.models;

import lombok.Data;

import java.util.Date;

@Data
public class User {

    private String id;
    private String name;
    private Date dateOfBirth;
    private Adress adress;
    private String description;
    private Date createdAd;
    private String email;
    private Date updateAt;

}
