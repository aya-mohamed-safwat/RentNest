package com.example.RentNest.capital.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CapitalHouseRequest {
    private String location;
    private double size;
    private int bedroomsNum;
    private int bathroomsNum;
    private double price;
    private boolean availability;
    private String description;

}
