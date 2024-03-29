package com.example.RentNest.user;

import com.example.RentNest.user.dto.LoginRequest;
import com.example.RentNest.user.dto.UpdateRequest;
import com.example.RentNest.user.dto.UserRequest;
import com.example.RentNest.user.dto.UserResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="/rentNest/api")
public class UserController {

    private final UserService userservice;

    @Autowired
    public UserController(UserService userservice) {
        this.userservice = userservice;
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<UserResponse> getById(@PathVariable Long id) {
        UserResponse response =userservice.getResponseById(id);
        return ResponseEntity.ok(response);
    }

    @GetMapping(path ="/getUsers")
    public  ResponseEntity<List<UserResponse>> getUsers() {
        List<UserResponse> response =userservice.findAllUsers();
        return ResponseEntity.ok(response);
    }


    @PostMapping(path = "/signUp")
    public ResponseEntity<?>  signUp(@RequestBody UserRequest request) {
        String msg= userservice.addNewUser(request);
        return ResponseEntity.ok(msg);
    }


    @PostMapping (path = "/login")
    public ResponseEntity<?>  login(@RequestBody LoginRequest loginRequest) {
       String msg= userservice.loginUser(loginRequest);
        return ResponseEntity.ok(msg);
    }

    @DeleteMapping(path = "/deleteUser/{userId}")
    public ResponseEntity<?>  deleteUser(@PathVariable Long userId) {
        String msg=userservice.deleteUser(userId);
        return ResponseEntity.ok(msg);
    }


    @PutMapping(path = "/updateUser/{userId}")
    public ResponseEntity<?> updateUser(@PathVariable Long userId,
                             @RequestBody UpdateRequest request) {

        String msg= userservice.UpdateUser(userId, request);
        return ResponseEntity.ok(msg);

    }

}
