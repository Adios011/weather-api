package com.muhsener98.weather.infrastructure;

import com.muhsener98.weather.service.WeatherClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Service("weatherClient")
public class VisualCrossingWeatherClient implements WeatherClient {

    @Value("${weather.client.url}")
    private String apiUrl;

    private final String apiKey;

    public VisualCrossingWeatherClient(){
        apiKey = System.getenv("WEATHER_API_KEY");

        if(apiKey == null)
            throw new VisualCrossingConnectionException("No environment variable found with provided key: WEATHER_API_KEY" );

        apiUrl =
            "https://weather.visualcrossing.com/VisualCrossingWebServices/rest/services/timeline/" +
                    "<city>?unitGroup=us&include=current&key=<yourApiKey>&contentType=json";
    }




    @Override
    public String getByCityName(String cityName) throws VisualCrossingConnectionException, VisualCrossingInvalidParameterException {
        String url  = apiUrl.replace("<yourApiKey>" , apiKey).replace("<city>" , cityName);

        System.err.println("in client -> " + cityName);
        System.err.println("apiURL ->   " + url);


        try {
            HttpRequest request = HttpRequest.newBuilder()
                    .GET()
                    .uri(new URI(url))
                    .build();

            HttpClient client = HttpClient.newHttpClient();
            HttpResponse<String> response = client.send(request , HttpResponse.BodyHandlers.ofString());

            int statusCode = response.statusCode();
            System.out.println("status Code -> " + statusCode);
            System.out.println("body -> " + response.body());

            switch (statusCode){
                case 200 -> response.body();
                case 401 -> throw new VisualCrossingConnectionException(response.body());
                case 400 -> throw new VisualCrossingInvalidParameterException(response.body() + String.format("-> {%s}" , cityName));
            };

            return response.body();

        } catch (URISyntaxException | IOException | InterruptedException e) {
            throw new VisualCrossingConnectionException(e.getMessage() , e);
        }


    }
}
