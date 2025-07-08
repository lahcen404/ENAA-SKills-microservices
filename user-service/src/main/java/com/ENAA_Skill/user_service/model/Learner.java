package com.ENAA_Skill.user_service.model;

import jakarta.persistence.Entity;

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
}
