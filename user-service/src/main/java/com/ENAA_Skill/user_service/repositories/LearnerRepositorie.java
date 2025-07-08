package com.ENAA_Skill.user_service.repositories;

import com.ENAA_Skill.user_service.model.Learner;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LearnerRepositorie extends JpaRepository<Learner, Long> {
}
