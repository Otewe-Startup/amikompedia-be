package com.example.amikompedia.service;

import com.example.amikompedia.entity.Register;
import com.example.amikompedia.repository.RegisterRepository;
import org.springframework.stereotype.Service;

//TODO: Service layer should be only for business logic
// based on the references on programmer zaman now
@Service
public class RegisterService {

    private final RegisterRepository registerRepository;

    public RegisterService(RegisterRepository registerRepository) {
        this.registerRepository = registerRepository;
    }

    public boolean isEmailOrNimTaken(String email, String nim){

        //TODO: why twice call to database?
        // u can just get the result and check email and nim is exist or not
        return registerRepository.existsByEmail(email) || registerRepository.existsByNim(nim);
    }

    public void save(Register register){
        registerRepository.save(register);
    }
}
