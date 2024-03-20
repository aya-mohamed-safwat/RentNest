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
    @GetMapping("/getById/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id) {
        User user = userservice.getByUserId(id);
        if (user == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(user);
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

    @DeleteMapping(path = "/deleteUser/{id}")
    public ResponseEntity<?>  deleteUser(@PathVariable Long userId) {
        String msg=userservice.deleteUser(userId);
        return ResponseEntity.ok(msg);
    }

    @PutMapping(path = "/updateUser")
    public String updateUser(@PathVariable Long userId,
                             @RequestBody UserRequest request) {

        userservice.UpdateUser(userId, request);
        return "update successfully";
    }

}
