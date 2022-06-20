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

    public ValidationResult isLastNameValid(User user){
        return UserValidation.isLastNameValid().apply(user);
    }

    public ValidationResult isUsernameValid(User user) {
        return UserValidation.isUsernameValid().apply(user);
    }

    public ValidationResult isEmailValid(User user) {
        return UserValidation.isEmailValid().apply(user);
    }

    public ValidationResult isPasswordValid(User user) {
        return UserValidation.isPasswordValid().apply(user);
    }

    public ValidationResult isAgeValid(User user) {
        return UserValidation.isAgeValid().apply(user);
    }
}
