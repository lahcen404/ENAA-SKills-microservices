package com.ENAA_Skill.user_service.repositories;


import com.ENAA_Skill.user_service.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepositorie extends JpaRepository<User, Long> {
    boolean existsByEmail(String email);
    Optional<User> findById(Long id);

}

