package com.example.RentNest.image;

import com.example.RentNest.user.User;
import lombok.*;
import org.hibernate.annotations.Type;

import javax.persistence.*;

//@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Table(name = "images")
public class Image {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private String contentType;

    @Enumerated(EnumType.STRING)
    private ImageEntityType entityType;

    private Long entityId;

    @Lob
    @Type(type = "org.hibernate.type.ImageType")
    private byte[] imageData;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

}
