package com.cognizant.orm_learn_query.model;

import javax.persistence.*;

@Entity
public class Product {

    @Id
    private int id;

    private String name;
    private double price;
    private String cpu;
    private int ram;
    private String os;

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }

    public String getCpu() { return cpu; }
    public void setCpu(String cpu) { this.cpu = cpu; }

    public int getRam() { return ram; }
    public void setRam(int ram) { this.ram = ram; }

    public String getOs() { return os; }
    public void setOs(String os) { this.os = os; }
}
