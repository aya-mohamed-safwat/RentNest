package com.example.RentNest.capital;

import com.example.RentNest.capital.dto.CapitalHouseRequest;
import com.example.RentNest.capital.dto.CapitalHouseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value="/rentNest/api")
public class CapitalHouseController {

    private final CapitalHouseService capitalHouseService;

    @Autowired
    public CapitalHouseController(CapitalHouseService capitalHouseService) {
        this.capitalHouseService = capitalHouseService;
    }

    @GetMapping(path ="/getAllCapitalHouses")
    public ResponseEntity<List<CapitalHouseResponse>> getHouses() {
        List<CapitalHouseResponse> response = capitalHouseService.findAllHouses();
        return ResponseEntity.ok(response);
    }

    @PutMapping("updateCapitalHouse/{id}")
    public ResponseEntity<CapitalHouseResponse> updateHouse(@PathVariable Long id, @Valid @RequestBody CapitalHouseRequest request) {
        CapitalHouseResponse response = capitalHouseService.update(id, request);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping(path = "/deleteCapitalHouse/{HouseId}")
    public ResponseEntity<?>  deleteHouse(@PathVariable Long HouseId) {
        String msg= capitalHouseService.deleteHouse(HouseId);
        return ResponseEntity.ok(msg);
    }

    @GetMapping(path ="/searchCapitalHousesByFilter")
    public ResponseEntity<List<CapitalHouseResponse>> searchHousesByFilter(@Valid @RequestParam String location,
                                                                           @Valid @RequestParam (required = false)  double size,
                                                                           @Valid @RequestParam (required = false) double price,
                                                                           @Valid @RequestParam (required = false) int bedroomsNum,
                                                                           @Valid @RequestParam (required = false) int bathroomsNum) {
        List<CapitalHouseResponse> response = capitalHouseService.search(location,size,price,bedroomsNum,bathroomsNum);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/addCapitalHouse/{userId}")
    public ResponseEntity<CapitalHouseResponse> addHouse(@PathVariable Long userId, @Valid @RequestBody CapitalHouseRequest request){
        CapitalHouseResponse response = capitalHouseService.addNewHouse(request , userId);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/getUserCapitalHouse/{userId}")
    public ResponseEntity<List<CapitalHouseResponse>> getUserHouse(@PathVariable Long userId){
       List<CapitalHouseResponse> response = capitalHouseService.getUserHouses(userId);
        return ResponseEntity.ok(response);
    }
}
