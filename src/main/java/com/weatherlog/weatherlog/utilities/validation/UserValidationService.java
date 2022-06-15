package com.weatherlog.weatherlog.utilities.validation;


import com.weatherlog.weatherlog.dto.UserDto;
import com.weatherlog.weatherlog.models.User;
import org.springframework.stereotype.Service;

@Service
public class UserValidationService {

    public UserValidation.ValidationResult validate(UserDto userDto) {
        return UserValidation.validateAll(userDto);
    }

}
