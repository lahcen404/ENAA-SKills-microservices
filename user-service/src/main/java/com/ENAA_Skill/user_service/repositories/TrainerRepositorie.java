package com.ENAA_Skill.user_service.repositories;

import com.ENAA_Skill.user_service.model.Trainer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TrainerRepositorie extends JpaRepository<Trainer, Long> {
}
