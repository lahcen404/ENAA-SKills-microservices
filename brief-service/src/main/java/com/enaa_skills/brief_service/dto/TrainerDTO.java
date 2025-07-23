package com.enaa_skills.brief_service.dto;

import jakarta.persistence.Column;
import lombok.Data;

@Data
public class TrainerDTO {
    private Long id;
    private String username;
    @Column(unique = true)
    private String email;
}
