package com.cognizant.orm_learn_query.model;

import javax.persistence.*;

@Entity
public class AttemptOption {

    @Id
    private int id;

    @ManyToOne
    @JoinColumn(name = "attempt_question_id")
    private AttemptQuestion attemptQuestion;

    @ManyToOne
    @JoinColumn(name = "option_id")
    private Option option;

    @Column(name = "is_selected")
    private boolean selected;

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public AttemptQuestion getAttemptQuestion() { return attemptQuestion; }
    public void setAttemptQuestion(AttemptQuestion attemptQuestion) { this.attemptQuestion = attemptQuestion; }

    public Option getOption() { return option; }
    public void setOption(Option option) { this.option = option; }

    public boolean isSelected() { return selected; }
    public void setSelected(boolean selected) { this.selected = selected; }
}
