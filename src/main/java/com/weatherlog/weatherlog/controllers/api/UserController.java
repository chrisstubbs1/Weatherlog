package com.weatherlog.weatherlog.controllers.api;

import com.weatherlog.weatherlog.models.User;
import com.weatherlog.weatherlog.services.UserService;
import com.weatherlog.weatherlog.utilities.validation.UserValidation;
import com.weatherlog.weatherlog.utilities.validation.UserValidationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

import static com.weatherlog.weatherlog.utilities.validation.UserValidation.*;

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
        ValidationResult userValidationResult = userValidationService.validate(user);

        if (userValidationResult.equals(ValidationResult.SUCCESS)){
            userService.addUser(user);
            logger.info("User {} Added.", user.getId());

            return ResponseEntity
                    .created(URI.create(String.format("/api/users/%d", user.getId())))
                    .build();

        }

        logger.info("Could not add user. Error: {}", userValidationResult.name());
        return new ResponseEntity<String>("Could not process request.", HttpStatus.BAD_REQUEST);

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
