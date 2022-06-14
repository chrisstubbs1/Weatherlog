package com.weatherlog.weatherlog.utilities.validation;


import com.weatherlog.weatherlog.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserValidationService {

    public UserValidation.ValidationResult validate(User user) {
        return UserValidation.validate(user);
    }

}
