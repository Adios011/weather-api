package com.muhsener98.weather.service;

import java.util.concurrent.TimeUnit;

public interface CacheService<K,V> {

    V get(K key);

    void set(K key, V value);

    void set(K key, V value, long timeout , TimeUnit timeUnit);


}
