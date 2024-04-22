package com.example.RentNest.houses;


import com.example.RentNest.houses.dto.HouseRequest;
import com.example.RentNest.houses.dto.HouseResponse;
import com.example.RentNest.user.User;
import com.example.RentNest.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
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

//    @Autowired
//    private ImageService imageService;

    public List<HouseResponse> findAllHouses() {
        return HouseMapper.INSTANCE.mapList(houseRepository.findAll());
    }

    public House getHouseById(Long id) {
        Optional<House> houseOptional = houseRepository.findById(id);
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
                    findByLocationAndSizeLessThanEqualAndPriceLessThanEqualAndBedroomsNumLessThanEqualAndBathroomsNumLessThanEqual
                            (location, size, price, bedroomsNum, bathroomsNum));
        } else {
            return findAllHouses();

        }
    }

    public HouseResponse addNewHouse( HouseRequest request , Long userId){
        House house = HouseMapper.INSTANCE.map(request);
    //    List<String> listImages = new ArrayList<>();

       // try {
         //   for (MultipartFile image : request.getImages()) {
           //     String addImage = imageService.uploadImage(image);
             //   listImages.add(addImage);
            //}
        //} catch (IOException e) {
          //  e.printStackTrace();
       // }
        //house.setImages(listImages);
        Optional<User> userOptional = userRepository.findById(userId);
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            house.setUser(user);
            user.getHouses().add(house);
            houseRepository.save(house);
            return HouseMapper.INSTANCE.map(house);
        }
        return null ;
    }




}
