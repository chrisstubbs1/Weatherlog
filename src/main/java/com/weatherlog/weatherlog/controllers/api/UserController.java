package com.weatherlog.weatherlog.controllers.api;

import com.weatherlog.weatherlog.dao.UserService;
import com.weatherlog.weatherlog.models.User;
import com.weatherlog.weatherlog.utilities.validation.UserValidation;
import com.weatherlog.weatherlog.utilities.validation.UserValidationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/users")
public class UserController {
    Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    UserService userService;
    @Autowired
    UserValidationService userValidationService;

    @GetMapping
    public List<User> getAllUsers() {
        logger.info("All users retrieved.");
        return userService.getAllUsers();
    }

    @GetMapping(path = "{id}")
    public User getUserById(@PathVariable Long id) {
        logger.info(String.format("User %d retrieved.", id));
        return userService.getUserById(id);
    }

    @PostMapping
    public void addUser(@RequestBody User user) {
        UserValidation.ValidationResult result = userValidationService.validate(user);

        if (result.equals(UserValidation.ValidationResult.SUCCESS)){
            logger.info("Added a new user.");
            userService.addUser(user);

            return;
        }

        logger.info("Could not add new user.");
        throw new IllegalStateException(result.name());
    }
}
