package com.cognizant.orm_learn_query.model;

import javax.persistence.*;

@Entity
@Table(name = "options")
public class Option {

    @Id
    private int id;

    private String text;

    @Column(name = "is_correct")
    private boolean correct;

    private double score;

    @ManyToOne
    @JoinColumn(name = "question_id")
    private Question question;

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getText() { return text; }
    public void setText(String text) { this.text = text; }

    public boolean isCorrect() { return correct; }
    public void setCorrect(boolean correct) { this.correct = correct; }

    public double getScore() { return score; }
    public void setScore(double score) { this.score = score; }

    public Question getQuestion() { return question; }
    public void setQuestion(Question question) { this.question = question; }
}
