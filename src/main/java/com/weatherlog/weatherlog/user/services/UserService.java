package com.weatherlog.weatherlog.user.services;

import com.weatherlog.weatherlog.user.dao.UserRepository;
import com.weatherlog.weatherlog.user.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public User getUserById(Long id) {
        return userRepository.findById(id).get();
    }

    public Optional<User> addUser(User userToAdd) {
        return Optional.of(userRepository.save(userToAdd));
    }

    public void removeById(Long iD) {
        userRepository.deleteById(iD);
    }
}
