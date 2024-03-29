package com.example.RentNest.houses;

import com.example.RentNest.houses.dto.HouseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HouseService {

    private final HouseRepository houseRepository;

    @Autowired
    public HouseService(HouseRepository houseRepository){
        this.houseRepository=houseRepository;
    }


    public List<HouseResponse> findAllHouses() {
        return HouseMapper.INSTANCE.mapList(houseRepository.findAll());
    }

    public String deleteHouse(Long id){
        boolean exist = houseRepository.existsById(id);
        if(!exist){
            return("this Id" +id+ " does not exist");
        }
        houseRepository.deleteById(id);
        return("this House is deleted");

    }

}
