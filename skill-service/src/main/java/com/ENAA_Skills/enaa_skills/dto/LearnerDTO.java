package com.ENAA_Skills.enaa_skills.dto;

import jakarta.validation.constraints.NotBlank;

public class LearnerDTO {
    private Long id;
    @NotBlank(message = "Learner name cannot be blank")
    private String name;
    private String email;


    public LearnerDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
