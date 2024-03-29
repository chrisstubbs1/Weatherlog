package com.weatherlog.weatherlog.user.services;

import com.weatherlog.weatherlog.user.dao.UserRepository;
import com.weatherlog.weatherlog.user.model.User;
import com.weatherlog.weatherlog.weatherevent.model.WeatherEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();
        userRepository.findAll().forEach(users::add);

        return users;
    }
//    public List<WeatherEvent> usersWeatherEvents(Long userId) {
//
//    }

    public User getUserById(Long id) {
        return userRepository.findById(id).get();
    }

    public Optional<User> addUser(User userToAdd) {
        return Optional.of(userRepository.save(userToAdd));
    }

    public void removeById(Long iD) {
        userRepository.deleteById(iD);
    }

//    public Boolean isUsernameTaken(String usernameToCheck) {
//        return getAllUsers().stream()
//                .anyMatch(user -> user.getUsername().equals(usernameToCheck));
//    }

    public Boolean isEmailAddressTaken(String emailAddressToCheck) {
        return getAllUsers().stream()
                        .anyMatch(user -> user.getEmail().equals(emailAddressToCheck));
    }
}
