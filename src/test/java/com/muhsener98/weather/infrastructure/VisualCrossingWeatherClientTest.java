package com.muhsener98.weather.infrastructure;

import com.muhsener98.weather.exception.WeatherClientInvalidParameterException;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Value;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class VisualCrossingWeatherClientTest {




    private VisualCrossingWeatherClient client;
    private String cityName;

    @BeforeEach
    public void setup(){
        cityName = "London";
        client = new VisualCrossingWeatherClient();
    }

    @Test
    public void testGet_SUCCESS() throws VisualCrossingInvalidParameterException {
        String result = client.getByCityName(cityName);

        assertTrue(result.length() > 100);

        System.out.println(result);
    }


    @Test
    public void testGet_WrongCity()  {
        WeatherClientInvalidParameterException exception =
                assertThrows(WeatherClientInvalidParameterException.class ,
                        () -> client.getByCityName("alksdjaks"));

        assertEquals(exception.getMessage() , "Bad API Request:Invalid location parameter value.-> {alksdjaks}");
    }




}
