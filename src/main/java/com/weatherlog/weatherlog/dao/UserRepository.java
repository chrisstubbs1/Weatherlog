package com.weatherlog.weatherlog.dao;

import com.weatherlog.weatherlog.models.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
}
