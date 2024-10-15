package com.muhsener98.weather;

import java.util.*;
public class Test {

    public static void main(String[] args) {
        System.out.println(System.getProperty("WEATHER_API_KEY"));
        Map<String, String> map = System.getenv();

        for(Map.Entry<String,String> entry : map.entrySet()){
            System.out.println(entry.getKey()  + " -> " +  entry.getValue());
        }

    }
}
