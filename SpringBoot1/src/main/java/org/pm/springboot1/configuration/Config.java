package org.pm.springboot1.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;

@Configuration
public class Config {
    public Config() {
        System.out.println("Config Bean is created");
    }

    @Bean
    public LocalDate createDate(){
        return LocalDate.now();
    }
}
