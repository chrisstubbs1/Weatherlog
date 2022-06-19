package com.weatherlog.weatherlog.weatherevent.model;

import lombok.Data;
import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Data
@Table
@Entity
public class WeatherEvent {

    private String location;
    private double temperature;
    private LocalDate date;
    private String comment;
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    protected WeatherEvent(){}

    public WeatherEvent(String location, double temperature, String comment, LocalDate date) {
        this.location = location;
        this.temperature = temperature;
        this.date = date;
        this.comment = comment;
    }
}
