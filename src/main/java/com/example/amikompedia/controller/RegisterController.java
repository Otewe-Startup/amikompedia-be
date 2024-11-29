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
//TODO: why /api/register?
// better this is /api for general, then /register u can put on the request mapping on method
@RequestMapping("/api/register")
public class RegisterController {

    private final RegisterService registerService;

    public RegisterController(RegisterService registerService) {
        this.registerService = registerService;
    }

    //TODO: please do based on the references on programmer zaman now
    // The business logic should be in service layer
    // Controller should be only for request mapping and response
    @PostMapping
    public ResponseEntity<String> registerUser(@Valid @RequestBody Register register){
        if (!register.getPassword().equals(register.getConfirmPassword())) {

            //TODO: please create a global custom response object for error
            // Wrap the base response on response entity, u can do like this ReponseEntity<BaseResponse>
            return ResponseEntity.badRequest().body("Password does not match");
        }

        if (registerService.isEmailOrNimTaken(register.getEmail(), register.getNim())){
            return ResponseEntity.badRequest().body("Email or Nim already exists");
        }

        //TODO: where the hashing password?
        // U cannot save password as plain text, u need to hash it
        registerService.save(register);

        //TODO: please create a global custom response object for success
        return ResponseEntity.ok("User Register Succesfully");
    }
}
