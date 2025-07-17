package com.ENAA_Skill.user_service.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

import java.util.List;

@Entity
public class Learner extends User {
    public Learner() {
        super();
    }

    public Learner(String username, String email, String password) {
        super(username, email, password);
    }

    @OneToMany
    @JsonIgnore
    private List<Submission> submissions;

    public List<Submission> getSubmissions() {
        return submissions;
    }

    public void setSubmissions(List<Submission> submissions) {
        this.submissions = submissions;
    }
}
