package com.weatherlog.weatherlog.user.validation;

import com.weatherlog.weatherlog.user.model.User;
import com.weatherlog.weatherlog.validation.ValidationResult;

import java.time.LocalDate;
import java.time.Period;
import java.util.function.Function;
import java.util.function.Predicate;

import static com.weatherlog.weatherlog.user.validation.UserValidation.*;
import static com.weatherlog.weatherlog.validation.ValidationResult.*;
import static com.weatherlog.weatherlog.validation.ValidationResult.valid;

public interface UserValidation extends Function<User, ValidationResult> {

    static UserValidation holds(Predicate<User> p, String message) {
        return user -> p.test(user) ? valid() : inValid(message);
    }

    static UserValidation isFirstNameValid() {
        return holds(user -> user.getFirstName().length() > 2, "User name Invalid" );
    }

    static UserValidation isLastNameValid() {
        return holds(user -> user.getLastName().length() > 2, "Last name invalid.");
    }

    static UserValidation isUsernameValid() {
        return holds(user -> user.getUsername().length() >= 4, "User name invalid.");
    }

    static UserValidation isEmailValid() {
        return holds(user -> user.getEmail().contains("@"), "Email invalid");
    }

    static UserValidation isPasswordValid() {
        return holds(user -> user.getPassword().length() > 8, "Password invalid.");
    }

    static UserValidation isAgeValid() {

        return holds(user -> {
            LocalDate userBirthDate = LocalDate.parse(user.getBirthday());
            return Period.between(userBirthDate, LocalDate.now()).getYears() >= -1;
        }, "Invalid age");
    }

    static ValidationResult validateAll(User user) {
        return isFirstNameValid()
                .and(isLastNameValid())
                .and(isUsernameValid())
                .and(isEmailValid())
                .and(isPasswordValid())
                .and(isAgeValid())
                .apply(user);
    }

    default UserValidation and(UserValidation other) {
        return user -> {
            final ValidationResult result = this.apply(user);
            return result.isValid() ? other.apply(user) : result;
        };
    }
}
