package com.weatherlog.weatherlog.user.validation;

import com.weatherlog.weatherlog.user.model.User;
import com.weatherlog.weatherlog.user.services.UserService;
import com.weatherlog.weatherlog.validation.ValidationResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDate;
import java.time.Period;
import java.util.function.Function;
import java.util.function.Predicate;

import static com.weatherlog.weatherlog.user.validation.UserValidation.*;
import static com.weatherlog.weatherlog.validation.ValidationResult.*;
import static com.weatherlog.weatherlog.validation.ValidationResult.valid;

public interface UserValidation extends Function<User, ValidationResult> {

    Logger logger = LoggerFactory.getLogger(UserValidation.class);

    static UserValidation holds(Predicate<User> p, String message) {
        return user -> p.test(user) ? valid() : inValid(message);
    }

    static UserValidation isFirstNameValid() {
        return holds(user -> user.getFirstName().length() > 2, "User name Invalid");
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
        return holds(user -> convertDate(user), "Invalid age");
    }

    static boolean convertDate(User user) {
        final LocalDate userBirthDate = LocalDate.parse(user.getBirthday());
        return Period.between(userBirthDate, LocalDate.now()).getYears() >= -1;
    }

    static UserValidation isUsernameAvailable(User user, UserService userService) {
        String potentialUsername = user.getUsername();
        final Predicate<User> usernameTest = u -> userService.getAllUsers()
                .stream()
                .map(User::getUsername)
//                this will evaluate to true if the username is already taken.
                .noneMatch(uu -> uu.equals(potentialUsername));

        return holds(usernameTest, "Username is already taken");
    }

    static UserValidation isEmailTaken(User user, UserService userService) {
        //if this predicate is false then the email address is NOT taken
        String potentialEmail = user.getEmail();
        final Predicate<User> test = u -> userService.getAllUsers().stream()
                .map(User::getEmail)
                .noneMatch(uu -> uu.equals(potentialEmail));

        return holds(test, "Email already taken.");
    }

    static ValidationResult validateAllUserFields(User user, UserService userService) {
        return isFirstNameValid()
                .and(isLastNameValid())
                .and(isUsernameValid())
                .and(isEmailValid())
                .and(isPasswordValid())
                .and(isAgeValid())
                .and(isUsernameAvailable(user, userService))
                .and(isEmailTaken(user, userService))
                .apply(user);
    }

    default UserValidation and(UserValidation other) {
        return user -> {
            final ValidationResult result = this.apply(user);
            return result.isValid() ? other.apply(user) : result;
        };
    }
}
