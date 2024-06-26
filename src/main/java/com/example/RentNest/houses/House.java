package com.example.RentNest.houses;

import com.example.RentNest.user.User;
import lombok.*;

import javax.persistence.*;


@Setter
@Getter
@Entity
@Table(name = "Houses")
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class House {
    @Id

    @SequenceGenerator(
            name = "house_sequence",
            sequenceName = "house_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "house_sequence"
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

    private boolean availability;

    private String description;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

}
