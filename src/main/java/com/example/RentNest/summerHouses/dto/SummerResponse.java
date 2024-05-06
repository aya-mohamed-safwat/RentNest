package com.example.RentNest.summerHouses.dto;

import com.example.RentNest.user.User;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class SummerResponse {
    private User user;
    private Long summerHouseId;
    private String location;
    private double size;
    private int bedroomsNum;
    private int bathroomsNum;
    private double price;
    private boolean availability;
    private String description;
}
