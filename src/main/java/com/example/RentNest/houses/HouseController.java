package com.example.RentNest.houses;

import com.example.RentNest.houses.dto.HouseRequest;
import com.example.RentNest.houses.dto.HouseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value="/rentNest/api")
public class HouseController {

    private final HouseService houseService;

    @Autowired
    public HouseController(HouseService houseService) {
        this.houseService = houseService;
    }

    @GetMapping(path ="/getAllHouses")
    public ResponseEntity<List<HouseResponse>> getHouses() {
        List<HouseResponse> response =houseService.findAllHouses();
        return ResponseEntity.ok(response);
    }

    @PutMapping("updateHouse/{id}")
    public ResponseEntity<HouseResponse> updateHouse(@PathVariable Long id, @Valid @RequestBody HouseRequest request) {
        HouseResponse response = houseService.update(id, request);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping(path = "/deleteHouse/{HouseId}")
    public ResponseEntity<?>  deleteHouse(@PathVariable Long HouseId) {
        String msg=houseService.deleteHouse(HouseId);
        return ResponseEntity.ok(msg);
    }

    @GetMapping(path ="/searchHousesByFilter")
    public ResponseEntity<List<HouseResponse>> searchHousesByFilter(@Valid @RequestParam String location,
                                                              @Valid @RequestParam (required = false)  double size,
                                                              @Valid @RequestParam (required = false) double price,
                                                              @Valid @RequestParam (required = false) int bedroomsNum,
                                                              @Valid @RequestParam (required = false) int bathroomsNum) {
        List<HouseResponse> response =houseService.search(location,size,price,bedroomsNum,bathroomsNum);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/addHouse/{userId}")
    public ResponseEntity<HouseResponse> addHouse(@PathVariable Long userId, @Valid @RequestBody HouseRequest request){
        HouseResponse response = houseService.addNewHouse(request , userId);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/getUserHouse/{userId}")
    public ResponseEntity<List<HouseResponse>> getUserHouse(@PathVariable Long userId){
       List<HouseResponse> response = houseService.getUserHouses(userId);
        return ResponseEntity.ok(response);
    }
}
