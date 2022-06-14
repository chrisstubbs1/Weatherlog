package com.weatherlog.weatherlog.dao;

import com.weatherlog.weatherlog.models.WeatherEvent;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WeatherEventsRepository extends CrudRepository<WeatherEvent, Long> {

}
