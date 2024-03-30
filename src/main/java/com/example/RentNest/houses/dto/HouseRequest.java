package com.example.RentNest.houses.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class HouseRequest {
    private String location;
    private double size;
    private int bedroomsNum;
    private int bathroomsNum;
    private double price;
    private boolean priceNegotiation;
    private boolean availability;
    private String description;
    private String categories;
}
