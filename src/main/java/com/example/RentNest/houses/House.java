package com.example.RentNest.houses;
import lombok.*;
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
    private double size;

    private int bedroomsNum;

    private int bathroomsNum;

    @Column(nullable = false)
    private double price;

    private boolean priceNegotiation;

    private boolean availability;

    private String description;

    @Column(nullable = false)
    private String categories;
}
