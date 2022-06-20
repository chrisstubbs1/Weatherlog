package com.weatherlog.weatherlog.weatherevent.validation;

import com.weatherlog.weatherlog.user.validation.UserValidation;
import com.weatherlog.weatherlog.validation.ValidationResult;
import com.weatherlog.weatherlog.weatherevent.model.WeatherEvent;

import java.util.function.Function;
import java.util.function.Predicate;

import static com.weatherlog.weatherlog.validation.ValidationResult.inValid;
import static com.weatherlog.weatherlog.validation.ValidationResult.valid;

public interface WeatherEventValidation extends Function<WeatherEvent, ValidationResult> {

    static WeatherEventValidation holds(Predicate<WeatherEvent> p, String message){
        return weatherEvent -> p.test(weatherEvent) ? valid() : inValid(message);
    }

    static WeatherEventValidation isLocationValid() {
        return holds(weatherEvent -> weatherEvent.getLocation().contains(","), "Location Invalid.");
    }

    static WeatherEventValidation isTemperatureValid() {
        return holds(weatherEvent -> weatherEvent.getTemperature() >= -200.0 &&
                weatherEvent.getTemperature() <= 200.0, "Temperature Invalid");
    }

    static ValidationResult validateAll(WeatherEvent weatherEvent) {
        return isLocationValid()
                .and(isTemperatureValid())
                .apply(weatherEvent);
    }

    default WeatherEventValidation and(WeatherEventValidation other) {
        return user -> {
            final ValidationResult result = this.apply(user);
            return result.isValid() ? other.apply(user) : result;
        };
    }
}
