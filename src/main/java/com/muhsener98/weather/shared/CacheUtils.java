package com.muhsener98.weather.shared;

public class CacheUtils {

    private static final String WEATHER_CACHE_PREFIX = "weather#";

    public static String generateWeatherCacheKey(String cityName){
        return WEATHER_CACHE_PREFIX + cityName;
    }
}
