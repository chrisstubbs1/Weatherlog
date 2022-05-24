package com.weatherlog.weatherlog.models;

import lombok.Data;
import javax.persistence.*;
import java.util.Date;

@Data
@Table
@Entity
public class WeatherEvent {

    private String location;
    private double temperature;
    private Date date;
    private String comment;
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    protected WeatherEvent(){}

    public WeatherEvent(String location, double temperature, String comment) {
        this.location = location;
        this.temperature = temperature;
        this.date = new Date();
        this.comment = comment;
    }
}
