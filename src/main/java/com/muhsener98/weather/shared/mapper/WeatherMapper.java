package com.muhsener98.weather.shared.mapper;

import com.muhsener98.weather.io.model.WeatherResponse;
import com.muhsener98.weather.service.WeatherInformation;
import com.muhsener98.weather.shared.dto.WeatherDTO;
import jdk.jshell.spi.ExecutionControl;

public class WeatherMapper {

    public WeatherDTO toDTO(WeatherInformation weatherInformation){
        throw  new RuntimeException("Not implemented yet!");
    }


    public WeatherResponse toResponse(WeatherDTO dto){
        throw  new RuntimeException("Not implemented yet!");
    }
}
