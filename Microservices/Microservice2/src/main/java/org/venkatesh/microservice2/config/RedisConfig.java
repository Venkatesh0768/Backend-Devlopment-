package org.venkatesh.microservice2.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.venkatesh.microservice2.model.Country;

@Configuration
public class RedisConfig {

    //jedis Connetion Factory
    @Bean
    public JedisConnectionFactory jedisConnectionFactory(){
        return new JedisConnectionFactory();
    }

    //Redis Template
    @Bean
    public RedisTemplate<String , Country> redisTemplate(){
        RedisTemplate<String ,Country> redisTemplate = new RedisTemplate<>();
        redisTemplate.setConnectionFactory(jedisConnectionFactory());
        return redisTemplate;
    }
}
