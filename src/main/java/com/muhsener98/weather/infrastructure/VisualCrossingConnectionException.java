package com.muhsener98.weather.infrastructure;

import com.muhsener98.weather.exception.WeatherClientException;

public class VisualCrossingConnectionException extends WeatherClientException {

    public VisualCrossingConnectionException(String message) {
        super(message);
    }

    public VisualCrossingConnectionException(String message, Throwable cause) {
        super(message, cause);
    }
}
