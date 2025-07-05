package com.cognizant.orm_learn_query.model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class AttemptQuestion {

    @Id
    private int id;

    @ManyToOne
    @JoinColumn(name = "attempt_id")
    private Attempt attempt;

    @ManyToOne
    @JoinColumn(name = "question_id")
    private Question question;

    @OneToMany(mappedBy = "attemptQuestion")
    private Set<AttemptOption> attemptOptions;

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public Attempt getAttempt() { return attempt; }
    public void setAttempt(Attempt attempt) { this.attempt = attempt; }

    public Question getQuestion() { return question; }
    public void setQuestion(Question question) { this.question = question; }

    public Set<AttemptOption> getAttemptOptions() { return attemptOptions; }
    public void setAttemptOptions(Set<AttemptOption> attemptOptions) { this.attemptOptions = attemptOptions; }
}
