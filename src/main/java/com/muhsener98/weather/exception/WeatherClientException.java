package com.muhsener98.weather.exception;

public class WeatherClientException extends RuntimeException{

    public WeatherClientException(String message) {
        super(message);
    }

    public WeatherClientException(String message, Throwable cause) {
        super(message, cause);
    }
}
