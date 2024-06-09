package com.example.RentNest.houses;


import com.example.RentNest.houses.dto.HouseRequest;
import com.example.RentNest.houses.dto.HouseResponse;
import com.example.RentNest.user.User;
import com.example.RentNest.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class HouseService {
 private final HouseRepository houseRepository;

 @Autowired
    public HouseService(HouseRepository houseRepository) {
        this.houseRepository = houseRepository;
    }
    @Autowired
    private UserRepository userRepository;

    public List<HouseResponse> findAllHouses() {
        return HouseMapper.INSTANCE.mapList(houseRepository.findAllByOrderByHouseIdAsc());
    }

    public House getHousesById(Long userId) {
        Optional<House> houseOptional = houseRepository.findById(userId);
        return houseOptional.orElse(null);
    }

    public HouseResponse update(Long id, HouseRequest request) {
        House house = houseRepository.getById(id);
        if (request != null) {
            HouseMapper.INSTANCE.updateEntity(request, house);
            house = houseRepository.save(house);
        }
        return HouseMapper.INSTANCE.map(house);
    }

    public String deleteHouse(Long id) {
        boolean exist = houseRepository.existsById(id);
        if (!exist) {
            return ("this Id" + id + " does not exist");
        }
        houseRepository.deleteById(id);
        return ("this House is deleted");

    }

    public List<HouseResponse> search(String location, double size, double price, int bedroomsNum, int bathroomsNum) {
        if (location != null || size != 0.0 || price != 0.0 || bedroomsNum != 0 || bathroomsNum != 0) {
            return HouseMapper.INSTANCE.mapList(houseRepository.
                    findByLocationAndSizeLessThanEqualAndPriceLessThanEqualAndBedroomsNumLessThanEqualAndBathroomsNumLessThanEqualOrderByHouseIdAsc
                            (location, size, price, bedroomsNum, bathroomsNum));
        } else {
            return findAllHouses();

        }
    }

    public HouseResponse addNewHouse( HouseRequest request , Long userId){
        House house = HouseMapper.INSTANCE.map(request);
        Optional<User> userOptional = userRepository.findById(userId);
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            house.setUser(user);
            houseRepository.save(house);
            return HouseMapper.INSTANCE.map(house);
        }
        return null ;
    }

    public List<HouseResponse> getUserHouses(Long userId) {
            List<House> house = houseRepository.findByUserIdOrderByHouseIdAsc(userId);
            return HouseMapper.INSTANCE.mapList(house);

    }




}
