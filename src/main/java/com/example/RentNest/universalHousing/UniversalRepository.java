package com.example.RentNest.universalHousing;
import com.example.RentNest.houses.House;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UniversalRepository extends JpaRepository<UniversalHouse, Long> {

    List<UniversalHouse> findByLocationAndSizeLessThanEqualAndPriceLessThanEqualAndBedroomsNumLessThanEqualAndBathroomsNumLessThanEqual
            (String location,double size,double price,int bedroomsNum,int bathroomsNum);

    List<UniversalHouse> findAllByOrderByUniversalHouseIdAsc();


    List<UniversalHouse> findByUserIdOrderByUniversalHouseIdAsc(Long userId);
}
