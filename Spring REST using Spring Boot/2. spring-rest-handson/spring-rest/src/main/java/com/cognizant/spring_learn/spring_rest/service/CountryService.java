package com.cognizant.spring_learn.spring_rest.service;

import com.cognizant.spring_learn.spring_rest.model.Country;
import com.cognizant.spring_learn.spring_rest.exception.CountryNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CountryService {

    private static final Logger LOGGER = LoggerFactory.getLogger(CountryService.class);

    @Autowired
    private Country country;

    @Autowired
    private List<Country> countryList;

    public Country getCountryIndia() {
        LOGGER.info("START");
        LOGGER.debug("Country: {}", country);
        LOGGER.info("END");
        return country;
    }

    public List<Country> getAllCountries() {
        LOGGER.info("START");
        LOGGER.debug("Country list size: {}", countryList.size());
        LOGGER.info("END");
        return countryList;
    }

    public Country getCountry(String code) throws CountryNotFoundException {
        LOGGER.info("START");
        LOGGER.debug("Looking for code: {}", code);
        LOGGER.debug("Injected country list size: {}", countryList.size());

        for (Country c : countryList) {
            LOGGER.debug("Comparing with: {}", c.getCode());
            if (c.getCode().equalsIgnoreCase(code)) {
                LOGGER.debug("Found: {}", c);
                LOGGER.info("END");
                return c;
            }
        }

        LOGGER.error("Country code not found: {}", code);
        throw new CountryNotFoundException();
    }
}
