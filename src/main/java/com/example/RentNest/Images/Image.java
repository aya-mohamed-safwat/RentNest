package com.example.RentNest.Images;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@Entity
@Table(name = "image")
public class Image {
    @Id
    @SequenceGenerator(
            name = "Image_sequence",
            sequenceName = "Image_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "Image_sequence"
    )
    private long id;

    private byte[] image;
}
