package com.example.RentNest.houses;

import com.example.RentNest.houses.dto.HouseRequest;
import com.example.RentNest.houses.dto.HouseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class HouseService {

    private final HouseRepository houseRepository;

    @Autowired
    public HouseService(HouseRepository houseRepository){
        this.houseRepository=houseRepository;
    }

    public House getHouseById(Long id) {
        Optional<House> userOptional = houseRepository.findById(id);
        return userOptional.orElse(null);
    }

    public List<HouseResponse> findAllHouses() {
        return HouseMapper.INSTANCE.mapList(houseRepository.findAll());
    }

    public HouseResponse update(Long id, HouseRequest request) {
        House house = getHouseById(id);
        if (house != null) {
            HouseMapper.INSTANCE.updateEntity(request, house);
            house = houseRepository.save(house);
        }
        return HouseMapper.INSTANCE.map(house);
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
