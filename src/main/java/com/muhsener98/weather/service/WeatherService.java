package com.muhsener98.weather.service;

import com.muhsener98.weather.exception.WeatherClientInvalidParameterException;
import com.muhsener98.weather.shared.dto.WeatherDTO;

public interface WeatherService {

    String getWeatherInformationByCityName(String cityName) throws WeatherClientInvalidParameterException;
}
