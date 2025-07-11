package com.cognizant.spring_learn.rest_handson.fourth.model;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class Country {

    @NotNull(message = "Code cannot be null")
    @Size(min = 2, max = 2, message = "Code should be exactly 2 characters")
    private String code;

    @NotNull(message = "Name cannot be null")
    private String name;

    public Country() {}

    public Country(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public String getCode() { return code; }
    public void setCode(String code) { this.code = code; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    @Override
    public String toString() {
        return "Country [code=" + code + ", name=" + name + "]";
    }
}
