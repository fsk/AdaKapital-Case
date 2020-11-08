package com.adakapital.adakapitalbackendcase.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Data
@Document(collection = "USER")
@ApiModel(value = "Entity Model", description = "This Class is Entity Model for project of AdaKapital BackEnd test")
public class User {

    @Id
    @ApiModelProperty(value = "This property is Id for USER model")
    private String id;

    @ApiModelProperty(value = "This property is Name for USER model")
    private String name;

    @JsonFormat(pattern="yyyy-MM-dd")
    @ApiModelProperty(value = "This property is Date of Birth for USER model")
    private LocalDate dateOfBirth;

    @ApiModelProperty(value = "This property is Adress for USER model and This is an object. Look at the Adress class")
    private Adress adress;

    @ApiModelProperty(value = "This property is Description for USER model")
    private String description;

    @ApiModelProperty(value = "This property is CreatedAd for USER model. Question: When created this model.?")
    private String createdAd;

    @ApiModelProperty(value = "This property is e-mail for USER model")
    private String email;

    @ApiModelProperty(value = "This property is UpdateAd for USER model. Question: When updated this model.?")
    private String updatedAt;

    // Singleton design pattern. But this code scope is not used.
    /**
     *     private static User instance;
     *
     *     public static synchronized User getInstance(){
     *         if(instance == null)
     *             instance = new User();
     *         return instance;
     *     }
     */


}
