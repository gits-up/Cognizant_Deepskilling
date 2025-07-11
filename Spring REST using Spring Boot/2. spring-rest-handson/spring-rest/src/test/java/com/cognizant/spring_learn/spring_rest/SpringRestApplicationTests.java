package com.cognizant.spring_learn.spring_rest;

import com.cognizant.spring_learn.spring_rest.controller.CountryController;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class SpringRestApplicationTests {

    @Autowired
    private CountryController countryController;

    @Autowired
    private MockMvc mvc;

    @Test
    public void contextLoads() {
        assertThat(countryController).isNotNull();
    }

    @Test
    public void testGetCountryIndia() throws Exception {
        mvc.perform(get("/country"))
           .andExpect(status().isOk())
           .andExpect(jsonPath("$.code").value("IN"))
           .andExpect(jsonPath("$.name").value("India"));
    }

    @Test
    public void testGetCountryByCode() throws Exception {
        mvc.perform(get("/countries/US"))
           .andExpect(status().isOk())
           .andExpect(jsonPath("$.code").value("US"))
           .andExpect(jsonPath("$.name").value("United States"));
    }

    @Test
    public void testGetCountryByCode_Exception() throws Exception {
        mvc.perform(get("/countries/xyz"))
           .andExpect(status().isNotFound())
           .andExpect(status().reason("Country not found"));
    }
}
