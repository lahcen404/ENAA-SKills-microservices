package com.ENAA_Skill.user_service.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

import java.util.List;

@Entity
public class Learner extends User {
    // Default constructor
    public Learner() {
        super();
    }

    // Constructor to easily create a Learner with basic details
    public Learner(String username, String email, String password) {
        super(username, email, password);
    }

    @OneToMany
    @JsonIgnore // facultatif si tu ne veux pas exposer les submissions

    private List<Submission> submissions;

    public List<Submission> getSubmissions() {
        return submissions;
    }

    public void setSubmissions(List<Submission> submissions) {
        this.submissions = submissions;
    }
}
