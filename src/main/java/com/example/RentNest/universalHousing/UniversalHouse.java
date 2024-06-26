package com.example.RentNest.universalHousing;

import com.example.RentNest.user.User;
import lombok.*;

import javax.persistence.*;

@Setter
@Getter
@Entity
@Table (name = "universalHouse")
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UniversalHouse {
    @Id
    @SequenceGenerator(
            name = "uni_sequence",
            sequenceName = "uni_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "uni_sequence"
    )
    @Column(nullable = false)
    private Long universalHouseId;

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
