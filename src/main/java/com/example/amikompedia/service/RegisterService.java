package com.example.amikompedia.service;

import com.example.amikompedia.entity.Register;
import com.example.amikompedia.repository.RegisterRepository;
import org.springframework.stereotype.Service;

@Service
public class RegisterService {

    private final RegisterRepository registerRepository;

    public RegisterService(RegisterRepository registerRepository) {
        this.registerRepository = registerRepository;
    }

    public boolean isEmailOrNimTaken(String email, String nim){
        return registerRepository.existsByEmail(email) || registerRepository.existsByNim(nim);
    }

    public void save(Register register){
        registerRepository.save(register);
    }
}
