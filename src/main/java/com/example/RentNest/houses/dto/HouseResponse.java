package com.example.RentNest.houses.dto;

import com.example.RentNest.Images.Image;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
public class HouseResponse {
    private String location;
    private double size;
    private int bedroomsNum;
    private int bathroomsNum;
    private double price;
    private boolean availability;
    private String description;
    private List<Image> images = new ArrayList<>();

}
