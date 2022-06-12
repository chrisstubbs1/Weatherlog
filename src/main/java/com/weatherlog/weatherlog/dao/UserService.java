package com.weatherlog.weatherlog.dao;

import com.weatherlog.weatherlog.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public List<User> getAllUsers(){
        List<User> users = new ArrayList<>();
        userRepository.findAll().forEach(users::add);

        return users;
    }

    public User getUserById(Long id){
        return userRepository.findById(id).get();
    }

    public void addUser(User userToAdd){
        userRepository.save(userToAdd);
    }

    public void removeById(Long iD){
        userRepository.deleteById(iD);
    }
}
