package com.example.RentNest.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Setter
@Getter
public class UpdateRequest {
    @NotNull(message = "name is required.")
    private String name;

    @NotNull(message = "email is required.")
    private String email;

    private String number;
}
