package com.enaa_skills.enaa_skills.dto;

import com.enaa_skills.enaa_skills.model.ValidationStatus;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class SubSkillDTO {
    private Long id;
    private String name;
    @NotNull
    private String description;
    // private ValidationStatus status;

    public SubSkillDTO(Long id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
       // this.status = status;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    // public void setStatus(ValidationStatus status) {
        //this.status = status;
    //}
}
