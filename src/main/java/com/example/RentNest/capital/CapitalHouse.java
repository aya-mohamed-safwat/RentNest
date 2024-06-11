package com.example.RentNest.capital;

import com.example.RentNest.user.User;
import lombok.*;

import javax.persistence.*;


@Setter
@Getter
@Entity
@Table(name = "CapitalHouses")
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CapitalHouse {
    @Id

    @SequenceGenerator(
            name = "capitalHouse",
            sequenceName = "capitalHouse",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "capitalHouse"
    )

    @Column(nullable = false)
    private Long capitalHouseId;

    @Column(nullable = false)
    private String location;

    @Column(nullable = false)
    private double size;

    private int bedroomsNum;

    private int bathroomsNum;

    @Column(nullable = false)
    private double price;

    private boolean availability;

    private String description;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

}
