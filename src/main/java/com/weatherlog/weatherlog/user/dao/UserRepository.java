package com.weatherlog.weatherlog.user.dao;

import com.weatherlog.weatherlog.user.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
}
