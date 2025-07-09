package org.budgetmanager.validationservice.Model;

import jakarta.persistence.*;

@Entity
public class SkillValidation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long submissionId;
    private Long subSkillId;

    @Enumerated(EnumType.STRING)
    private ValidationStatus status;

    // No-arg constructor
    public SkillValidation() {
    }

    // All-arg constructor
    public SkillValidation(Long id, Long submissionId, Long subSkillId, ValidationStatus status) {
        this.id = id;
        this.submissionId = submissionId;
        this.subSkillId = subSkillId;
        this.status = status;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getSubmissionId() {
        return submissionId;
    }

    public void setSubmissionId(Long submissionId) {
        this.submissionId = submissionId;
    }

    public Long getSubSkillId() {
        return subSkillId;
    }

    public void setSubSkillId(Long subSkillId) {
        this.subSkillId = subSkillId;
    }

    public ValidationStatus getStatus() {
        return status;
    }

    public void setStatus(ValidationStatus status) {
        this.status = status;
    }


}
