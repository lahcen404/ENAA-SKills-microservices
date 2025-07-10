package com.ENAA_Skill.user_service.model;

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
    private List<Submission> submissions;

    public List<Submission> getSubmissions() {
        return submissions;
    }

    public void setSubmissions(List<Submission> submissions) {
        this.submissions = submissions;
    }
}
