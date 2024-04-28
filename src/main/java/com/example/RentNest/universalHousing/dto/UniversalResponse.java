package com.example.RentNest.universalHousing.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UniversalResponse {
    private Long universalHouseId;
    private String location;
    private double size;
    private int bedroomsNum;
    private int bathroomsNum;
    private double price;
    private boolean availability;
    private String description;

}
