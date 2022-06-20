package com.weatherlog.weatherlog.weatherevent.validation;

import com.weatherlog.weatherlog.validation.ValidationResult;
import com.weatherlog.weatherlog.weatherevent.model.WeatherEvent;
import org.springframework.stereotype.Service;

@Service
public class WeatherEventValidationService {

    public ValidationResult validateAll(WeatherEvent weatherEvent) {
        return WeatherEventValidation.validateAll(weatherEvent);
    }

    public ValidationResult isLocationValid(WeatherEvent weatherEvent) {
        return WeatherEventValidation.isLocationValid().apply(weatherEvent);
    }

    public ValidationResult isTemperature(WeatherEvent weatherEvent) {
        return WeatherEventValidation.isTemperatureValid().apply(weatherEvent);
    }
}
