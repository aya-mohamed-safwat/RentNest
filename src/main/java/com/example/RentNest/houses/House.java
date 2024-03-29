package com.example.RentNest.houses;
import lombok.*;
import java.awt.Image;
import java.util.List;
import javax.persistence.*;

@Setter
@Getter
@Entity
@Table (name = "house")
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class House {
    @Id
    @SequenceGenerator(
            name = "House_sequence",
            sequenceName = "House_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "House_sequence"
    )
    @Column(nullable = false)
    private Long houseId;

    @Column(nullable = false)
    private String location;

    @Column(nullable = false)
    private int size;

    @Column(nullable = false)
    private int bedroomsNum;

    @Column(nullable = false)
    private int bathroomsNum;

    private List<Image> image;

    @Column(nullable = false)
    private int price;

    private boolean priceNegotiation;

    private boolean availability;

    private String description;

    @Column(nullable = false)
    private String categories;
}
