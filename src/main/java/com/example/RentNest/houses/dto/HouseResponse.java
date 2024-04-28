package com.example.RentNest.houses.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class HouseResponse {
    private Long HouseId;
    private String location;
    private double size;
    private int bedroomsNum;
    private int bathroomsNum;
    private double price;
    private boolean availability;
    private String description;

}
