package com.example.amikompedia.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "register")
public class Register {

    @Id
    private String fullName;

    private String email;

    private String nim;

    private String password;

    private String confirmPassword;
}
