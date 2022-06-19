package com.weatherlog.weatherlog.user.validation;

import com.weatherlog.weatherlog.user.model.User;
import com.weatherlog.weatherlog.validation.ValidationResult;
import org.springframework.stereotype.Service;


@Service
public class UserValidationService {

    public ValidationResult validateAll(User user) {
        return UserValidation.validateAll(user);
    }

    public ValidationResult isFistNameValid(User user){
        return UserValidation.isFirstNameValid().apply(user);
    }



}
