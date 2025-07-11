package com.cognizant.spring_learn.rest_handson.fourth.model;

import jakarta.validation.constraints.NotNull;

public class Skill {
    @NotNull(message = "Skill id cannot be null")
    private Integer id;

    @NotNull(message = "Skill name cannot be null")
    private String name;

    public Skill() {}

    public Skill(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    @Override
    public String toString() {
        return "Skill [id=" + id + ", name=" + name + "]";
    }
}
