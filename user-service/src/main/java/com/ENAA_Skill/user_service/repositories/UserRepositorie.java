package com.ENAA_Skill.user_service.repositories;

import com.ENAA_Skill.user_service.model.Learner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepositorie extends JpaRepository<Learner, Long> {
    boolean existsByEmail(String email);
}
