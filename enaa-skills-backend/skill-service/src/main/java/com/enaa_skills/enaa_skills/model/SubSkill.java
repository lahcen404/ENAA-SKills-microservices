package com.enaa_skills.enaa_skills.model;

import jakarta.persistence.*;
import lombok.Data;


@Data
@Entity
@Table(name = "sub_skills")
public class SubSkill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

//    @Enumerated(EnumType.STRING)
//    private ValidationStatus status = ValidationStatus.NOT_VALIDATE;

    private String description;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "skill_id", nullable = false)
    private Skill skill;


    public SubSkill(String name, String description, ValidationStatus status) {
        this.name = name;
//        this.status = status;
        this.description = description;
    }

    public SubSkill() {

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

//    public ValidationStatus getStatus() {
//        return status;
//    }
//
//    public void setStatus(ValidationStatus status) {
//        this.status = status;
//    }

    public Skill getSkill() {
        return skill;
    }

    public void setSkill(Skill skill) {
        this.skill = skill;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
