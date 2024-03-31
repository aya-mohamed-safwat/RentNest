package com.example.RentNest.universalHousing;

import com.example.RentNest.universalHousing.dto.UniversalRequest;
import com.example.RentNest.universalHousing.dto.UniversalResponse;
import com.example.RentNest.user.User;
import com.example.RentNest.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UniversalService {

    private final UniversalRepository universalRepository;

    @Autowired
    private UserRepository userRepository;


    @Autowired
    public UniversalService(UniversalRepository universalRepository) {
        this.universalRepository = universalRepository;
    }

    public UniversalHouse getHouseById(Long id) {
        Optional<UniversalHouse> houseOptional = universalRepository.findById(id);
        return houseOptional.orElse(null);
    }

    public List<UniversalResponse> findAllHouses() {
        return UniversalMapper.INSTANCE.mapList(universalRepository.findAll());
    }

    public UniversalResponse update(Long id, UniversalRequest request) {
        UniversalHouse universalHouse = getHouseById(id);
        if (universalHouse != null) {
            UniversalMapper.INSTANCE.updateEntity(request, universalHouse);
            universalHouse = universalRepository.save(universalHouse);
        }
        return UniversalMapper.INSTANCE.map(universalHouse);
    }

    public String deleteHouse(Long id) {
        boolean exist = universalRepository.existsById(id);
        if (!exist) {
            return ("this Id" + id + " does not exist");
        }
        universalRepository.deleteById(id);
        return ("this House is deleted");

    }

    public List<UniversalResponse> search(String location, double size, double price, int bedroomsNum, int bathroomsNum) {
        if (location != null || size != 0.0 || price != 0.0 || bedroomsNum != 0 || bathroomsNum != 0) {
            return UniversalMapper.INSTANCE.mapList(universalRepository.
                    findByLocationOrSizeLessThanEqualOrPriceLessThanEqualOrBedroomsNumLessThanEqualOrBathroomsNumLessThanEqual
                    (location, size, price, bedroomsNum, bathroomsNum));
        } else {
            return findAllHouses();

        }
    }

    public UniversalResponse addNewHouse(UniversalRequest request , Long userId){
        UniversalHouse universalHouse = UniversalMapper.INSTANCE.map(request);
        Optional<User> userOptional = userRepository.findById(userId);
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            universalHouse.setUser(user);
            user.getUniversalHouse().add(universalHouse);
            universalRepository.save(universalHouse);
            return UniversalMapper.INSTANCE.map(universalHouse);
        }
        return null ;
    }
}
