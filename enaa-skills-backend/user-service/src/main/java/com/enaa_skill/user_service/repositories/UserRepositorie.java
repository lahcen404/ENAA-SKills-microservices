package com.enaa_skill.user_service.repositories;


import com.enaa_skill.user_service.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface UserRepositorie extends JpaRepository<User, Long> {
    boolean existsByEmail(String email);
    Optional<User> findById(Long id);

}

