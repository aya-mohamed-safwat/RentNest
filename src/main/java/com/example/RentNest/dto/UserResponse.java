package com.example.RentNest.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UserResponse {
    private Long id;
    private String name;
    private String email;
    private String number;
    private String nationalId;
    private String password;
}
