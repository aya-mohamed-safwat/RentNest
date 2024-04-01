package com.example.RentNest.summerHouses;

import com.example.RentNest.summerHouses.dto.SummerRequest;
import com.example.RentNest.summerHouses.dto.SummerResponse;
import com.example.RentNest.user.User;
import com.example.RentNest.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SummerService {
 private final SummerRepository summerRepository ;

 @Autowired
    public SummerService(SummerRepository summerRepository) {
        this.summerRepository = summerRepository;
    }
    @Autowired
    private UserRepository userRepository;

    public List<SummerResponse> findAllHouses() {
        return SummerMapper.INSTANCE.mapList(summerRepository.findAll());
    }

    public SummerHouse getHouseById(Long id) {
        Optional<SummerHouse> houseOptional = summerRepository.findById(id);
        return houseOptional.orElse(null);
    }

    public SummerResponse update(Long id, SummerRequest request) {
        SummerHouse house = summerRepository.getById(id);
        if (request != null) {
            SummerMapper.INSTANCE.updateEntity(request, house);
            house = summerRepository.save(house);
        }
        return SummerMapper.INSTANCE.map(house);
    }

    public String deleteHouse(Long id) {
        boolean exist = summerRepository.existsById(id);
        if (!exist) {
            return ("this Id" + id + " does not exist");
        }
        summerRepository.deleteById(id);
        return ("this House is deleted");

    }

    public List<SummerResponse> search(String location, double size, double price, int bedroomsNum, int bathroomsNum) {
        if (location != null || size != 0.0 || price != 0.0 || bedroomsNum != 0 || bathroomsNum != 0) {
            return SummerMapper.INSTANCE.mapList(summerRepository.
                    findByLocationAndSizeLessThanEqualAndPriceLessThanEqualAndBedroomsNumLessThanEqualAndBathroomsNumLessThanEqual
                            (location, size, price, bedroomsNum, bathroomsNum));
        } else {
            return findAllHouses();

        }
    }

    public SummerResponse addNewHouse( SummerRequest request , Long userId){
        SummerHouse house = SummerMapper.INSTANCE.map(request);
        Optional<User> userOptional = userRepository.findById(userId);
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            house.setUser(user);
            user.getSummerHouses().add(house);
            summerRepository.save(house);
            return SummerMapper.INSTANCE.map(house);
        }
        return null ;
    }


}
