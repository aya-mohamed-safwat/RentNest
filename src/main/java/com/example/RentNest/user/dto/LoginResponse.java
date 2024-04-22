package com.example.RentNest.user.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class LoginResponse {
    private String msg;
    private UserResponse user;
}
