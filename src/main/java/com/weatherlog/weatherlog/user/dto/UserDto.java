package com.weatherlog.weatherlog.user.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;
import org.springframework.stereotype.Service;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@NoArgsConstructor
@Getter
@Setter
public class UserDto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    @Size(min = 2, max = 15)
    private String firstName;
    @NotNull
    @Size(min = 2, max = 15)
    private String lastName;
    private String username;
    @Email
    private String email;
    @JsonFormat(pattern="yyyy-MM-dd")
    private LocalDate birthDate;
    private String password;

    public UserDto(String firstName, String lastName, String username, String email, String password,
                LocalDate birthDate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.email = email;
        this.password = password;
        this.birthDate = birthDate;
    }
}
