package org.venkatesh.microservice2.service;

import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.venkatesh.microservice2.model.Country;

import java.util.Collection;
import java.util.Map;

@Service
public class CountryService {
    private HashOperations<String , Object , Object> opsForHash = null;

    public CountryService(RedisTemplate<String, Country> redisTemplate){
        opsForHash=redisTemplate.opsForHash();
    }

    public String addCountry(Country country){
        opsForHash.put("COUNTRIES" , country.getCountryName() , country);
        return "The country is added successfully";
    }

    public Collection<Object> getAllCountries(){
        Map<Object, Object> entries = opsForHash.entries("COUNTRIES");
        return entries.values();
    }
}
