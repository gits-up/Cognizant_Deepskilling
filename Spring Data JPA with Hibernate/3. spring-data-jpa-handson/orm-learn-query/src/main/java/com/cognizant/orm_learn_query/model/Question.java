package com.cognizant.orm_learn_query.model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Question {

    @Id
    private int id;

    private String text;

    @OneToMany(mappedBy = "question")
    private Set<Option> options;

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getText() { return text; }
    public void setText(String text) { this.text = text; }

    public Set<Option> getOptions() { return options; }
    public void setOptions(Set<Option> options) { this.options = options; }
}
