package com.example.RentNest.universalHousing;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UniversalRepository extends JpaRepository<UniversalHouse, Long> {

    List<UniversalHouse> findByLocationOrSizeLessThanEqualOrPriceLessThanEqualOrBedroomsNumLessThanEqualOrBathroomsNumLessThanEqual
            (String location,double size,double price,int bedroomsNum,int bathroomsNum);


}
