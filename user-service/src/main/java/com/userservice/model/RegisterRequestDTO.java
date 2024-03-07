package com.userservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequestDTO {
    private String userName;
    private String password;
    private String fullName;
    private String email;
    private String birthDate;
    private String gender;
}
