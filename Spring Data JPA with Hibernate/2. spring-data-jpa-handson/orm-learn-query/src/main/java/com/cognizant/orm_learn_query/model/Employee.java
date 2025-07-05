package com.cognizant.orm_learn_query.model;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "emp_id")
    private int id;

    @Column(name = "emp_name")
    private String name;

    @Column(name = "emp_salary")
    private double salary;

    @Column(name = "emp_doj")
    private Date dateOfJoining;

    @ManyToOne
    @JoinColumn(name = "dept_id", referencedColumnName = "dept_id")
    private Department department;
    
    @ManyToMany
    @JoinTable(name = "employee_skill",
        joinColumns = @JoinColumn(name = "emp_id"),
        inverseJoinColumns = @JoinColumn(name = "skill_id"))
    private List<Skill> skillList;


    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public double getSalary() { return salary; }
    public void setSalary(double salary) { this.salary = salary; }

    public Date getDateOfJoining() { return dateOfJoining; }
    public void setDateOfJoining(Date dateOfJoining) { this.dateOfJoining = dateOfJoining; }

    public Department getDepartment() { return department; }
    public void setDepartment(Department department) { this.department = department; }
    
    public List<Skill> getSkillList() { return skillList; }
    public void setSkillList(List<Skill> skillList) { this.skillList = skillList; }

    @Override
    public String toString() {
        return "Employee [id=" + id + ", name=" + name + ", salary=" + salary +
                ", doj=" + dateOfJoining + ", department=" + department.getName() + "]";
    }
}
