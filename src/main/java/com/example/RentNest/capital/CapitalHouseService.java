package com.example.RentNest.capital;


import com.example.RentNest.capital.dto.CapitalHouseRequest;
import com.example.RentNest.capital.dto.CapitalHouseResponse;
import com.example.RentNest.user.User;
import com.example.RentNest.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CapitalHouseService {
 private final CapitalHouseRepository capitalHouseRepository;

 @Autowired
    public CapitalHouseService(CapitalHouseRepository capitalHouseRepository) {
        this.capitalHouseRepository = capitalHouseRepository;
    }
    @Autowired
    private UserRepository userRepository;

    public List<CapitalHouseResponse> findAllHouses() {
        return CapitalHouseMapper.INSTANCE.mapList(capitalHouseRepository.findAllByOrderByCapitalHouseIdAsc());
    }

    public CapitalHouse getHousesById(Long userId) {
        Optional<CapitalHouse> houseOptional = capitalHouseRepository.findById(userId);
        return houseOptional.orElse(null);
    }

    public CapitalHouseResponse update(Long id, CapitalHouseRequest request) {
        CapitalHouse capitalHouse = capitalHouseRepository.getById(id);
        if (request != null) {
            CapitalHouseMapper.INSTANCE.updateEntity(request, capitalHouse);
            capitalHouse = capitalHouseRepository.save(capitalHouse);
        }
        return CapitalHouseMapper.INSTANCE.map(capitalHouse);
    }

    public String deleteHouse(Long id) {
        boolean exist = capitalHouseRepository.existsById(id);
        if (!exist) {
            return ("this Id" + id + " does not exist");
        }
        capitalHouseRepository.deleteById(id);
        return ("this House is deleted");

    }

    public List<CapitalHouseResponse> search(String location, double size, double price, int bedroomsNum, int bathroomsNum) {
        if (location != null || size != 0.0 || price != 0.0 || bedroomsNum != 0 || bathroomsNum != 0) {
            return CapitalHouseMapper.INSTANCE.mapList(capitalHouseRepository.
                    findByLocationAndSizeLessThanEqualAndPriceLessThanEqualAndBedroomsNumLessThanEqualAndBathroomsNumLessThanEqualOrderByCapitalHouseIdAsc
                            (location, size, price, bedroomsNum, bathroomsNum));
        } else {
            return findAllHouses();

        }
    }

    public CapitalHouseResponse addNewHouse(CapitalHouseRequest request , Long userId){
        CapitalHouse capitalHouse = CapitalHouseMapper.INSTANCE.map(request);
        Optional<User> userOptional = userRepository.findById(userId);
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            capitalHouse.setUser(user);
            capitalHouseRepository.save(capitalHouse);
            return CapitalHouseMapper.INSTANCE.map(capitalHouse);
        }
        return null ;
    }

    public List<CapitalHouseResponse> getUserHouses(Long userId) {
            List<CapitalHouse> capitalHouse = capitalHouseRepository.findByUserIdOrderByCapitalHouseIdAsc(userId);
            return CapitalHouseMapper.INSTANCE.mapList(capitalHouse);

    }




}
