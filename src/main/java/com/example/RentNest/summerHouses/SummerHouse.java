package com.example.RentNest.summerHouses;

import com.example.RentNest.user.User;
import lombok.*;

import javax.persistence.*;

@Setter
@Getter
@Entity
@Table(name = "summerHouses")
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class SummerHouse {
    @Id
    @SequenceGenerator(
            name = "summ_sequence",
            sequenceName = "summ_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "summ_sequence"
    )
    @Column(nullable = false)
    private Long summerHouseId;

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
