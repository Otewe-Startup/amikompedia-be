package com.example.amikompedia.repository;

import com.example.amikompedia.entity.Register;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegisterRepository extends JpaRepository<Register, String> {

    boolean existsByEmail(String email);
    boolean existsByNim(String nim);
}
