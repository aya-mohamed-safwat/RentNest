package com.example.RentNest.user.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UserRequest {
    private String name;
    private String email;
    private String number;
    private String nationalId;
    private String password;

}
