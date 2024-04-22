package com.example.RentNest.houses.dto;

import com.example.RentNest.Images.Image;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Setter
@Getter
public class HouseRequest {
    private String location;
    private double size;
    private int bedroomsNum;
    private int bathroomsNum;
    private double price;
    private boolean availability;
    private String description;
    MultipartFile[] images;
}
