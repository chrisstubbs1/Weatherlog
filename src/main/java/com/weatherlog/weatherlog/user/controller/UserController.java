package com.weatherlog.weatherlog.user.controller;

import com.weatherlog.weatherlog.exception.WeatherlogException;
import com.weatherlog.weatherlog.user.model.User;
import com.weatherlog.weatherlog.user.services.UserService;
import com.weatherlog.weatherlog.user.validation.UserValidationService;
import com.weatherlog.weatherlog.validation.ValidationResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Optional;

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
    public ResponseEntity<String> addUser(RequestEntity<User> entity) {
        User user = entity.getBody();
        //make sure the user's information is valid before being saved to the database.
        ValidationResult result = userValidationService.validateAll(user);

        if (!result.isValid()) {
            logger.error("Could not add user. Error: {}", result.getReason().get());
            throw new WeatherlogException("Sorry, we could not add the user.");
        }

        userService.addUser(user);
        logger.info("User {} Added.", user.getId());

        return ResponseEntity
                .created(URI.create(String.format("/api/users/%d", user.getId())))
                .build();

    }

//    private User toEntity(UserDto userDto) {
//        User user = new User();
//
//        user.setFirstName(userDto.getFirstName());
//        user.setLastName(userDto.getLastName());
//        user.setUsername(userDto.getUsername());
//        user.setEmail(userDto.getEmail());
//        user.setBirthDate(userDto.getBirthDate());
//        user.setPassword(userDto.getPassword());
//
//        return user;
//    }
}
