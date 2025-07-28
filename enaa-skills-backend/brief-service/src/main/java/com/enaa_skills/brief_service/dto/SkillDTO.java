package com.enaa_skills.brief_service.dto;

import lombok.Data;

@Data
public class SkillDTO {
    private Long id;
    private String name;

    public SkillDTO(Long id, String name) {
        this.id = id;
        this.name = name;
    }
}
