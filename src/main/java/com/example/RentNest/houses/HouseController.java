package com.example.RentNest.houses;

import com.example.RentNest.houses.dto.HouseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
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

    @DeleteMapping(path = "/deleteHouse/{houseId}")
    public ResponseEntity<?>  deleteHouse(@PathVariable Long houseId) {
        String msg=houseService.deleteHouse(houseId);
        return ResponseEntity.ok(msg);
}
}