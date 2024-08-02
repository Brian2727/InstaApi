package com.gymbuddy.InstaApi.Security.DTOs;

import lombok.Data;

@Data
public class LogInDTO {
    private String password;
    private String userName;
}
