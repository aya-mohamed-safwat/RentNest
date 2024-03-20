package com.example.RentNest.user;

import com.example.RentNest.dto.LoginRequest;
import com.example.RentNest.dto.UserRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class UserService {
private final UserRepository userRepository;

@Autowired
public UserService(UserRepository userRepository){
    this.userRepository=userRepository;
}

    public User getByUserId(Long id) {
        Optional<User> userOptional = userRepository.findById(id);
        return userOptional.orElse(null); // Returns null if user is not found
    }

public String addNewUser(UserRequest request){
    User user = new User();
    Optional<User> UserByEmail = Optional.ofNullable(userRepository.findByEmail(request.getEmail()));
    if(UserByEmail.isPresent()){
        return("this email is existing");
    }
    user.setEmail(request.getEmail());
    user.setName(request.getName());
    user.setNumber(request.getNumber());
    user.setNationalId(request.getNationalId());
    user.setPassword(request.getPassword());
    userRepository.save(user);
    return("Email is created");
}

public String loginUser (LoginRequest loginRequest) {
        User user = userRepository.findByEmail(loginRequest.getEmail());
        if (user != null) {
            if (user.getPassword().equals(loginRequest.getPassword()))
            {
                Optional<User> getUser = userRepository.findOneByEmailAndPassword(loginRequest.getEmail(), loginRequest.getPassword());
                if (getUser.isPresent()) {
                    return "Login Success";
                } else {
                    return "Login Failed";
                }
            } else {
                return "Password is Wrong";
            }
        }
        else {
            return "Email not exist";
        }
    }

public String deleteUser(Long userId) {
    boolean exist = userRepository.existsById(userId);
    if(!exist){
        return("this Id" +userId+ " does not exist");
    }
    userRepository.deleteById(userId);
    return("this email is deleted");
    }

@Transactional
public void UpdateUser(Long userId, UserRequest request) {
    User user =userRepository.getById(userId);

    if(request!=null){
        user.setName(request.getName());
        user.setEmail(request.getEmail());
        user.setNumber(request.getNumber());
    }
    userRepository.save(user);
    }

}

