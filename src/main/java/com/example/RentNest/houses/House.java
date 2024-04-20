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

    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(nullable = false)
    private Long HouseId;

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

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
