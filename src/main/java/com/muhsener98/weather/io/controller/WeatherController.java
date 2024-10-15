package com.muhsener98.weather.io.controller;

import com.muhsener98.weather.exception.WeatherClientInvalidParameterException;
import com.muhsener98.weather.io.model.WeatherResponse;
import com.muhsener98.weather.service.WeatherService;
import com.muhsener98.weather.shared.dto.WeatherDTO;
import com.muhsener98.weather.shared.mapper.WeatherMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/weather")
public class WeatherController {

    private final WeatherService weatherService;


    public WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;

    }

    @GetMapping("/{cityName}")
    public ResponseEntity<String> getByCityName(@PathVariable("cityName") String cityName) throws WeatherClientInvalidParameterException {
        String responseBody = weatherService.getWeatherInformationByCityName(cityName);
        System.err.println("cityName - > " + cityName);
        return ResponseEntity.ok(responseBody);

    }

}
