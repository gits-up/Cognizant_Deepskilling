package com.cognizant.spring_learn.rest_handson.fourth.model;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.Date;
import java.util.List;

public class Employee {
    @NotNull(message = "Employee id cannot be null")
    private Integer id;

    @NotNull(message = "Employee name cannot be null")
    private String name;

    private double salary;

    private boolean permanent;

    private Date dateOfBirth;

    @NotNull(message = "Department must not be null")
    @Valid
    private Department department;

    @NotNull(message = "Skill list must not be null")
    @Size(min = 1, message = "There should be at least one skill")
    @Valid
    private List<Skill> skillList;

    public Employee() {}

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public double getSalary() { return salary; }
    public void setSalary(double salary) { this.salary = salary; }

    public boolean isPermanent() { return permanent; }
    public void setPermanent(boolean permanent) { this.permanent = permanent; }

    public Date getDateOfBirth() { return dateOfBirth; }
    public void setDateOfBirth(Date dateOfBirth) { this.dateOfBirth = dateOfBirth; }

    public Department getDepartment() { return department; }
    public void setDepartment(Department department) { this.department = department; }

    public List<Skill> getSkillList() { return skillList; }
    public void setSkillList(List<Skill> skillList) { this.skillList = skillList; }

    @Override
    public String toString() {
        return "Employee [id=" + id + ", name=" + name + ", salary=" + salary +
                ", permanent=" + permanent + ", dateOfBirth=" + dateOfBirth +
                ", department=" + department + ", skillList=" + skillList + "]";
    }
}
