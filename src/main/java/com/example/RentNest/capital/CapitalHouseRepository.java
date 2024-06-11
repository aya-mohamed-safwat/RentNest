package com.example.RentNest.capital;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CapitalHouseRepository extends JpaRepository<CapitalHouse, Long> {

    List<CapitalHouse> findByLocationAndSizeLessThanEqualAndPriceLessThanEqualAndBedroomsNumLessThanEqualAndBathroomsNumLessThanEqualOrderByCapitalHouseIdAsc
            (String location,double size,double price,int bedroomsNum,int bathroomsNum);


    List<CapitalHouse> findAllByOrderByCapitalHouseIdAsc();

    List<CapitalHouse> findByUserIdOrderByCapitalHouseIdAsc(Long userId);
}

