package com.muhsener98.weather.service;

import com.muhsener98.weather.exception.WeatherClientException;
import com.muhsener98.weather.exception.WeatherClientInvalidParameterException;
import com.muhsener98.weather.infrastructure.VisualCrossingInvalidParameterException;

public interface WeatherClient {


    String getByCityName(String cityName) throws WeatherClientException, WeatherClientInvalidParameterException;
}
