package com.weatherlog.weatherlog.models;

import lombok.Data;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Table
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private String username;
    private String email;
    private LocalDate birthDate;
    private String password;

    public User() {

    }

    public User(String firstName, String lastName, String username, String email, String password,
                LocalDate birthDate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.email = email;
        this.password = password;
        this.birthDate = birthDate;
    }


}
