package com.cognizant.spring_learn.spring_rest.config;

import com.cognizant.spring_learn.spring_rest.model.Country;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class CountryConfig {

    @Bean
    public Country country() {
        Country country = new Country();
        country.setCode("IN");
        country.setName("India");
        return country;
    }

    @Bean
    public List<Country> countryList() {
        List<Country> countries = new ArrayList<>();

        Country in = new Country();
        in.setCode("IN");
        in.setName("India");

        Country us = new Country();
        us.setCode("US");
        us.setName("United States");

        Country jp = new Country();
        jp.setCode("JP");
        jp.setName("Japan");

        Country de = new Country();
        de.setCode("DE");
        de.setName("Germany");

        countries.add(in);
        countries.add(us);
        countries.add(jp);
        countries.add(de);

        return countries;
    }
}
