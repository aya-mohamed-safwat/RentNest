package com.example.RentNest.houses;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HouseRepository extends JpaRepository<House, Long> {

    List<House> findByLocation(String location);
    List<House> findByPriceLessThanEqual(double price);
    List<House> findBySizeLessThanEqual(double size);
    List<House> findByBedroomsNumLessThanEqual(int bedroomsNum);
    List<House> findByBathroomsNumLessThanEqual(int bathroomsNum);
    List<House> findByLocationAndSizeLessThanEqual(String location,double size);

}
