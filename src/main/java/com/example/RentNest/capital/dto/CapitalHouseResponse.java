package com.example.RentNest.capital.dto;

import com.example.RentNest.user.User;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CapitalHouseResponse {
    private User user;
    private Long capitalHouseId;
    private String location;
    private double size;
    private int bedroomsNum;
    private int bathroomsNum;
    private double price;
    private boolean availability;
    private String description;

}
