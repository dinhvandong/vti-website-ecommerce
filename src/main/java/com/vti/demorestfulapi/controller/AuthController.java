package com.vti.demorestfulapi.controller;

import com.vti.demorestfulapi.model.ResponseObject;
import com.vti.demorestfulapi.model.User;
import com.vti.demorestfulapi.payload.request.LoginRequest;
import com.vti.demorestfulapi.repository.RoleRepository;
import com.vti.demorestfulapi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {
    @Autowired
    UserRepository userRepository;
    @Autowired
    RoleRepository roleRepository;

    @Autowired
    PasswordEncoder passwordEncoder;



    @PostMapping("/signin")
    public ResponseEntity<?> signIn(@RequestBody LoginRequest loginRequest){
        System.out.println("ABC");
        Optional<User> optionalUser = userRepository.findByUsername(loginRequest.getUsername());

        if(!optionalUser.isPresent()){
            return ResponseEntity.status(HttpStatus.OK).body(new
                    ResponseObject(201, "user not found",""));
        }
        User user = optionalUser.get();
        //A123456@

        String passwordEncode = passwordEncoder.encode(loginRequest.getPassword());

        if(user.getPassword().equals(passwordEncode)){

            return ResponseEntity.status(HttpStatus.OK).body(new
                    ResponseObject(200, "Login successful",""));
        }
        return ResponseEntity.status(HttpStatus.OK).body(new
                ResponseObject(202, "Incorrect password",""));

    }





}
