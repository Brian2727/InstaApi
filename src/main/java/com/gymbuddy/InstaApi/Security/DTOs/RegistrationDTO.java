package com.gymbuddy.InstaApi.Security.DTOs;

import lombok.Data;

@Data
public class RegistrationDTO {
    private String password;
    private String userName;
    private String firstName;
    private String lastName;
}
