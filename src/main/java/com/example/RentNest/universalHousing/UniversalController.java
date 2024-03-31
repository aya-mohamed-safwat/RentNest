package com.example.RentNest.universalHousing;

import com.example.RentNest.universalHousing.dto.UniversalRequest;
import com.example.RentNest.universalHousing.dto.UniversalResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value="/rentNest/api")
public class UniversalController {

    private final UniversalService universalService;

    @Autowired
    public UniversalController(UniversalService universalService) {
        this.universalService = universalService;
    }

    @GetMapping(path ="/getAllUniversalHouses")
    public ResponseEntity<List<UniversalResponse>> getAllUniversalHouses() {
        List<UniversalResponse> response = universalService.findAllHouses();
        return ResponseEntity.ok(response);
    }

    @PutMapping("updateUniversalHouse/{id}")
    public ResponseEntity<UniversalResponse> updateUniversalHouse(@PathVariable Long id, @Valid @RequestBody UniversalRequest request) {
        UniversalResponse response = universalService.update(id, request);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping(path = "/deleteUniversalHouse/{houseId}")
    public ResponseEntity<?>  deleteUniversalHouse(@PathVariable Long houseId) {
        String msg= universalService.deleteHouse(houseId);
        return ResponseEntity.ok(msg);
}

    @GetMapping(path ="/searchUniversalHousesByFilter")
    public ResponseEntity<List<UniversalResponse>> searchUniversalHousesByFilter(@Valid @RequestParam String location,
                                                              @Valid @RequestParam (required = false)  double size,
                                                              @Valid @RequestParam (required = false) double price,
                                                              @Valid @RequestParam (required = false) int bedroomsNum,
                                                              @Valid @RequestParam (required = false) int bathroomsNum) {
        List<UniversalResponse> response = universalService.search(location,size,price,bedroomsNum,bathroomsNum);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/addUniversalHouse/{userId}")
    public ResponseEntity<UniversalResponse> addUniversalHouse(@PathVariable Long userId, @Valid @RequestBody UniversalRequest request){
        UniversalResponse response = universalService.addNewHouse(request , userId);
        return ResponseEntity.ok(response);
    }
}