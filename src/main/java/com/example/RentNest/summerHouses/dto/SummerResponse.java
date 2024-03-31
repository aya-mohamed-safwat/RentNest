package com.example.RentNest.summerHouses.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class SummerResponse {
    private String location;
    private double size;
    private int bedroomsNum;
    private int bathroomsNum;
    private double price;
    private boolean priceNegotiation;
    private boolean availability;
    private String description;
}
