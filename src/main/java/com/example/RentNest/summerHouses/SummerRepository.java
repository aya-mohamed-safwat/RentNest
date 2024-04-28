package com.example.RentNest.summerHouses;

import com.example.RentNest.houses.House;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SummerRepository extends JpaRepository<SummerHouse, Long> {

    List<SummerHouse> findByLocationAndSizeLessThanEqualAndPriceLessThanEqualAndBedroomsNumLessThanEqualAndBathroomsNumLessThanEqual
            (String location,double size,double price,int bedroomsNum,int bathroomsNum);

    List<SummerHouse> findByUserId(Long userId);
}
