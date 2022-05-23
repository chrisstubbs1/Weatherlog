package com.weatherlog.weatherlog.models;

import lombok.Data;
import java.util.Date;
import java.util.UUID;

@Data
public class WeatherEvent {

    private String location;
    private double temperature;
    private Date date;
    private String comment;
    private UUID id;

    public WeatherEvent(String location, double temperature, Date date, String comment) {
        this.location = location;
        this.temperature = temperature;
        this.date = date;
        this.comment = comment;
        this.id = UUID.randomUUID();
    }
}
