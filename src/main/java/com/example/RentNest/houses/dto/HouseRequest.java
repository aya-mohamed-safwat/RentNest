package com.example.RentNest.houses.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;


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
   // private MultipartFile[] images;
    private List<MultipartFile> images = new ArrayList<>();
}
