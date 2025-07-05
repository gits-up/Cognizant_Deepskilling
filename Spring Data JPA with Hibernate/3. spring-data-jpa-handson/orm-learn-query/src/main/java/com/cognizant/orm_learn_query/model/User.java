package com.cognizant.orm_learn_query.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "user")
public class User {

    @Id
    private int id;

    private String name;

    @OneToMany(mappedBy = "user")
    private Set<Attempt> attempts;

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public Set<Attempt> getAttempts() { return attempts; }
    public void setAttempts(Set<Attempt> attempts) { this.attempts = attempts; }
}
