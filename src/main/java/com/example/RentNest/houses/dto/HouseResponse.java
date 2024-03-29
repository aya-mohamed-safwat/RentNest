package com.example.RentNest.houses.dto;

import lombok.Getter;
import lombok.Setter;
import java.awt.*;
import java.util.List;

@Setter
@Getter
public class HouseResponse {
    private String location;
    private int size;
    private int bedroomsNum;
    private int bathroomsNum;
    private List<Image> image;
    private int price;
    private boolean priceNegotiation;
    private boolean availability;
    private String description;
    private String categories;
}
