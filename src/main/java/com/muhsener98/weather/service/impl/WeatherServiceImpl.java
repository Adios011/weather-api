package com.muhsener98.weather.service.impl;

import com.muhsener98.weather.exception.WeatherClientInvalidParameterException;
import com.muhsener98.weather.service.CacheService;
import com.muhsener98.weather.service.WeatherClient;
import com.muhsener98.weather.service.WeatherService;
import com.muhsener98.weather.shared.CacheUtils;
import org.springframework.stereotype.Service;


import java.util.concurrent.TimeUnit;

@Service("weatherService")
public class WeatherServiceImpl implements WeatherService {

    private final long CACHE_TTL_MINUTES  = 5 ;


    private final CacheService<String,String> cacheService;
    private final WeatherClient weatherClient;


    public WeatherServiceImpl(CacheService<String,String> cacheService, WeatherClient weatherClient) {
        this.cacheService = cacheService;
        this.weatherClient = weatherClient;
    }

    @Override
    public String getWeatherInformationByCityName(String cityName) throws WeatherClientInvalidParameterException {
        System.err.println("cityName - > " + cityName);


        //TODO : ask for cache
        String cacheKey = CacheUtils.generateWeatherCacheKey(cityName);
        String weatherInfo = cacheService.get(cacheKey);

        if(weatherInfo != null){
            // Cache contains info
            return weatherInfo;
        }else {
            // Cache does not contain info
            weatherInfo = weatherClient.getByCityName(cityName);
            cacheService.set(cacheKey , weatherInfo , CACHE_TTL_MINUTES , TimeUnit.MINUTES );

            return weatherInfo;

        }

    }

}
