package com.example.RentNest.user;


import com.example.RentNest.user.dto.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User getByUserId(Long id) {
        Optional<User> userOptional = userRepository.findById(id);
        return userOptional.orElse(null);
    }

    public UserResponse getResponseById(Long id) {
        User user = getByUserId(id);
        return UserMapper.INSTANCE.map(user);
    }

    public List<UserResponse> findAllUsers() {
        return UserMapper.INSTANCE.mapList(userRepository.findAll());
    }

    public String addNewUser(UserRequest request) {
        User user = new User();
        Optional<User> UserByEmail = Optional.ofNullable(userRepository.findByEmail(request.getEmail()));
        if (UserByEmail.isPresent()) {
            return ("this email is existing");
        }
        user.setEmail(request.getEmail());
        user.setName(request.getName());
        user.setNumber(request.getNumber());
        user.setNationalId(request.getNationalId());
        user.setPassword(request.getPassword());
        userRepository.save(user);
        return ("Email is created");
    }

    public LoginResponse loginUser(LoginRequest loginRequest) {
        boolean loginSuccess = false;
        String msg = "";
        User user = userRepository.findByEmail(loginRequest.getEmail());
        if (user != null) {
            if (user.getPassword().equals(loginRequest.getPassword())) {
                Optional<User> getUser = userRepository.findOneByEmailAndPassword(loginRequest.getEmail(), loginRequest.getPassword());
                if (getUser.isPresent()) {
                    loginSuccess = true;
                    msg = "Login Success";
                } else {
                    msg = "Login Failed";
                }
            } else {
                msg = "Wrong Password";
            }
        } else {
            msg = "Email does not exist";
        }
        return new LoginResponse(msg, loginSuccess ? UserMapper.INSTANCE.map(user) : null);
    }

    public String deleteUser(Long userId) {
        boolean exist = userRepository.existsById(userId);
        if (!exist) {
            return ("this Id" + userId + " does not exist");
        }
        userRepository.deleteById(userId);
        return ("this email is deleted");
    }

    @Transactional
    public String UpdateUser(Long userId, UpdateRequest request) {
        User user = userRepository.getById(userId);

        if (request.getName() != null & request.getEmail() != null & request.getNumber() != null & request.getPassword() != null ) {
            user.setName(request.getName());
            user.setEmail(request.getEmail());
            user.setNumber(request.getNumber());
            user.setPassword(request.getPassword());

            userRepository.save(user);
            return ("done");
        }
        return ("name , Email and number is required ");
    }


}

