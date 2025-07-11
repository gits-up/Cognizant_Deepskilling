package com.cognizant.spring_learn.rest_handson.fourth.model;

import jakarta.validation.constraints.NotNull;

public class Department {
    @NotNull(message = "Department id cannot be null")
    private Integer id;

    @NotNull(message = "Department name cannot be null")
    private String name;

    public Department() {}

    public Department(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    @Override
    public String toString() {
        return "Department [id=" + id + ", name=" + name + "]";
    }
}
