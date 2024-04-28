package com.example.RentNest.summerHouses;

import com.example.RentNest.houses.dto.HouseResponse;
import com.example.RentNest.summerHouses.dto.SummerRequest;
import com.example.RentNest.summerHouses.dto.SummerResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value="/rentNest/api")
public class SummerController {

    private final SummerService summerService;

    @Autowired
    public SummerController(SummerService summerService) {
        this.summerService = summerService;
    }
    

    @GetMapping(path ="/getAllSummerHouses")
    public ResponseEntity<List<SummerResponse>> getSummerHouses() {
        List<SummerResponse> response =summerService.findAllHouses();
        return ResponseEntity.ok(response);
    }


    @PutMapping("updateSummerHouse/{id}")
    public ResponseEntity<SummerResponse> updateSummerHouse(@PathVariable Long id, @Valid @RequestBody SummerRequest request) {
        SummerResponse response = summerService.update(id, request);
        return ResponseEntity.ok(response);
    }


    @DeleteMapping(path = "/deleteSummerHouse/{summerHouseId}")
    public ResponseEntity<?>  deleteSummerHouse(@PathVariable Long summerHouseId) {
        String msg=summerService.deleteHouse(summerHouseId);
        return ResponseEntity.ok(msg);
    }


    @GetMapping(path ="/searchSummerHousesByFilter")
    public ResponseEntity<List<SummerResponse>> searchSummerHousesByFilter(@Valid @RequestParam String location,
                                                              @Valid @RequestParam (required = false)  double size,
                                                              @Valid @RequestParam (required = false) double price,
                                                              @Valid @RequestParam (required = false) int bedroomsNum,
                                                              @Valid @RequestParam (required = false) int bathroomsNum) {
        List<SummerResponse> response =summerService.search(location,size,price,bedroomsNum,bathroomsNum);
        return ResponseEntity.ok(response);
    }


    @PostMapping("/addSummerHouse/{userId}")
    public ResponseEntity<SummerResponse> addSummerHouse(@PathVariable Long userId, @Valid @RequestBody SummerRequest request){
        SummerResponse response = summerService.addNewHouse(request , userId);
        return ResponseEntity.ok(response);
    }
    @PostMapping("/getUserSummerHouse/{userId}")
    public ResponseEntity<List<SummerResponse>> getUserSummerHouse(@PathVariable Long userId){
        List<SummerResponse> response = summerService.getUserHouses(userId);
        return ResponseEntity.ok(response);
    }

}
