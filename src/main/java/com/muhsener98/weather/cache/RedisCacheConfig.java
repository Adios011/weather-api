//package com.muhsener98.weather.cache;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.data.redis.RedisConnectionFailureException;
//import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
//import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
//import org.springframework.data.redis.core.RedisTemplate;
//import org.springframework.data.redis.serializer.RedisSerializer;
//import org.springframework.data.redis.serializer.StringRedisSerializer;
//
//import java.util.Arrays;
//
//@Configuration
//public class RedisCacheConfig {
//
//
//
//    @Bean
//    public RedisTemplate<?,?> redisTemplate(){
//        RedisTemplate<?,?> redisTemplate = new RedisTemplate<>();
//        redisTemplate.setConnectionFactory(lettuceConnectionFactory());
//        redisTemplate.setDefaultSerializer(StringRedisSerializer.UTF_8);
//        redisTemplate.afterPropertiesSet();
//
//        return redisTemplate;
//
//    }
//
//
//    public LettuceConnectionFactory lettuceConnectionFactory(){
//        String[] redisConnectionStringInArray = redisConnectionString().split(":");
//        String hostName = redisConnectionStringInArray[0];
//        int port = Integer.parseInt(redisConnectionStringInArray[1]);
//
//
////        System.out.println("Redis connection String " + Arrays.toString(redisConnectionStringInArray));
//        LettuceConnectionFactory factory =
//                new LettuceConnectionFactory(hostName , port );
//        factory.afterPropertiesSet();
//        return factory;
//    }
//
//    public String redisConnectionString(){
//        String connectionString = System.getenv("REDIS_CONNECTION_STRING");
//        if(connectionString == null)
//            throw new RedisConnectionFailureException("No such environment variable found: REDIS_CONNECTION_STRING");
//
//        return connectionString;
//    }
//}
