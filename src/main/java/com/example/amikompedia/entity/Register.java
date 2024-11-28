package com.example.amikompedia.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
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
    @NotBlank(message = "full name is require")
    private String fullName;

    @Email(message = "Invalid email format")
    @NotBlank(message = "Email is require")
    private String email;

    @NotBlank(message = "NIM is require")
    private String nim;

    @Size(min = 4, message = "Password must be at least 4 characters")
    private String password;

    @Transient
    private String confirmPassword;
}
