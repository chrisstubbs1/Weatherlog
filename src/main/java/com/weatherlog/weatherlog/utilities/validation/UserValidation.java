package com.weatherlog.weatherlog.utilities.validation;

import com.weatherlog.weatherlog.models.User;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.util.function.Function;
import java.util.regex.Pattern;

import static com.weatherlog.weatherlog.utilities.validation.UserValidation.*;
import static com.weatherlog.weatherlog.utilities.validation.UserValidation.ValidationResult.*;

public interface UserValidation extends Function<User, ValidationResult> {

    static UserValidation isFirstNameValid() {
        return user -> user.getFirstName().length() > 2 ?
                SUCCESS : FIRSTNAME_INVALID;
    }

    static UserValidation isLastNameValid() {
        return user -> user.getLastName().length() > 2 ?
                SUCCESS : LASTNAME_INVALID;
    }

    static UserValidation isUsernameValid() {
        return user -> user.getUsername().length() > 4 ?
                SUCCESS : USERNAME_INVALID;
    }

    static UserValidation isEmailValid() {
        return user -> user.getEmail().contains("@") ? SUCCESS : EMAIL_INVALID;
    }

    static UserValidation isPasswordValid() {
        return user -> user.getPassword().length() > 8 ? SUCCESS : PASSWORD_INVALID;
    }

    static UserValidation isAgeValid() {
        return user -> Period.between(user.getBirthDate(), LocalDate.now()).getYears() > 3 ?
                SUCCESS : AGE_INVALID;
    }

    static ValidationResult validate(User user) {
        return isFirstNameValid()
                .and(isLastNameValid())
                .and(isUsernameValid())
                .and(isEmailValid())
                .and(isPasswordValid())
                .and(isAgeValid())
                .apply(user);
    }

    default UserValidation and(UserValidation other) {
        return customer -> {
            ValidationResult result = this.apply(customer);
            return result.equals(SUCCESS) ? other.apply(customer) : result;
        };

    }

    enum ValidationResult {
        SUCCESS,
        LASTNAME_INVALID,
        FIRSTNAME_INVALID,
        USERNAME_INVALID,
        EMAIL_INVALID,
        PASSWORD_INVALID,
        AGE_INVALID
    }
}
