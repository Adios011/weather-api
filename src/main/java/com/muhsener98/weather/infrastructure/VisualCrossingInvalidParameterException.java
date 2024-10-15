package com.muhsener98.weather.infrastructure;

import com.muhsener98.weather.exception.WeatherClientInvalidParameterException;

public class VisualCrossingInvalidParameterException extends WeatherClientInvalidParameterException {

    public VisualCrossingInvalidParameterException(String message) {
        super(message);
    }

    public VisualCrossingInvalidParameterException(String message, Throwable cause) {
        super(message, cause);
    }
}
