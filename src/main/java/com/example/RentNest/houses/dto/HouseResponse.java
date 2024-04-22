package com.example.RentNest.houses.dto;

import com.example.RentNest.Images.Image;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

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
    @ManyToOne
    @JoinColumn(name = "image_id")
    private Image image;

}
