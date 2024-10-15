package com.muhsener98.weather.exception.handler;

import com.muhsener98.weather.exception.WeatherClientInvalidParameterException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


import java.util.Date;

@ControllerAdvice
public class AppGlobalExceptionHandler {

    @ExceptionHandler(WeatherClientInvalidParameterException.class)
    public ResponseEntity<ErrorResponse> handleWeatherClientInvalidParameterException(WeatherClientInvalidParameterException exception, HttpServletRequest request) {

        ErrorResponse response = new ErrorResponse("Invalid parameter <cityName>",
                HttpStatus.BAD_REQUEST.value(), new Date(), request.getRequestURI());

        return ResponseEntity.badRequest().body(response);
    }

    @ExceptionHandler(RuntimeException.class)

    public ResponseEntity<ErrorResponse> handleRuntimeExceptions(RuntimeException runtimeException , HttpServletRequest request){
        ErrorResponse response = new ErrorResponse("unknown internal error.",
                HttpStatus.INTERNAL_SERVER_ERROR.value(), new Date(), request.getRequestURI());

        return ResponseEntity.badRequest().body(response);
    }


    private final class ErrorResponse {
        private String message;
        private int code;
        private Date timeStamp;
        private String path;

        ErrorResponse(String message, int code, Date timeStamp, String path) {
            this.message = message;
            this.code = code;
            this.timeStamp = timeStamp;
            this.path = path;
        }
    }
}
