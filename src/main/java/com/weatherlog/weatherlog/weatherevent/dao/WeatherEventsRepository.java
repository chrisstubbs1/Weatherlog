package com.weatherlog.weatherlog.weatherevent.dao;

import com.weatherlog.weatherlog.weatherevent.model.WeatherEvent;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WeatherEventsRepository extends CrudRepository<WeatherEvent, Long> {

}
