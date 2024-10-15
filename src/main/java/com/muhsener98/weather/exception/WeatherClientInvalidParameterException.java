package com.muhsener98.weather.exception;

public class WeatherClientInvalidParameterException extends Exception{

    public WeatherClientInvalidParameterException(String message) {
        super(message);
    }

    public WeatherClientInvalidParameterException(String message, Throwable cause) {
        super(message, cause);
    }
}
