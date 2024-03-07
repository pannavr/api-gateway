package com.userservice.model;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserInformationDTO {
    private int userId;
    private String userName;
    private String password;
    private String fullName;
    private String email;
    private String birthDate;
    private String gender;
    private String createDate;
    private String modifiedDate;
}

