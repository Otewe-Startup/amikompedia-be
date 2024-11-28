package com.example.amikompedia.controller;

import com.example.amikompedia.entity.Register;
import com.example.amikompedia.service.RegisterService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/register")
public class RegisterController {

    private final RegisterService registerService;

    public RegisterController(RegisterService registerService) {
        this.registerService = registerService;
    }

    @PostMapping
    public ResponseEntity<String> registerUser(@Valid @RequestBody Register register){
        if (!register.getPassword().equals(register.getConfirmPassword())) {
            return ResponseEntity.badRequest().body("Password does not match");
        }

        if (registerService.isEmailOrNimTaken(register.getEmail(), register.getNim())){
            return ResponseEntity.badRequest().body("Email or Nim already exists");
        }

        registerService.save(register);
        return ResponseEntity.ok("User Register Succesfully");
    }
}
