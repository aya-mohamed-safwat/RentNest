package com.example.RentNest.houses;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HouseRepository extends JpaRepository<House, Long> {

    List<House> findByLocationAndSizeLessThanEqualAndPriceLessThanEqualAndBedroomsNumLessThanEqualAndBathroomsNumLessThanEqual
            (String location,double size,double price,int bedroomsNum,int bathroomsNum);
}
