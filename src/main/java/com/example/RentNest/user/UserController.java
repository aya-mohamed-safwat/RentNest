package com.example.RentNest.user;

import com.example.RentNest.dto.LoginRequest;
import com.example.RentNest.dto.UserRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value="/rentNest/api")
public class UserController {

    private final UserService userservice;

    @Autowired
    public UserController(UserService userservice) {
        this.userservice = userservice;
    }

    @GetMapping("/{id}")
    public User getById(@PathVariable Long id) {
        return userservice.getByUserId(id);
    }

    @PostMapping
    public ResponseEntity<?>  SignUp(@RequestBody UserRequest request) {
        String msg= userservice.addNewUser(request);
        return ResponseEntity.ok(msg);
    }


    @PostMapping (path = "/login")
    public ResponseEntity<?>  Login(@RequestBody LoginRequest loginRequest) {
       String msg= userservice.loginUser(loginRequest);
        return ResponseEntity.ok(msg);
    }

    @DeleteMapping(path = "{userId}")
    public ResponseEntity<?>  deleteUser(@PathVariable Long userId) {
        String msg=userservice.deleteUser(userId);
        return ResponseEntity.ok(msg);
    }

    @PutMapping(path = "{userId}")
    public String updateUser(@PathVariable Long userId,
                             @RequestBody UserRequest request) {

        userservice.UpdateUser(userId, request);
        return "update successfully";
    }

}
