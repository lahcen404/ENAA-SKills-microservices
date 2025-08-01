package com.enaa_skill.user_service.repositories;


import com.enaa_skill.user_service.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;


public interface UserRepositorie extends JpaRepository<User, Long> {
    Optional<User> findById(Long id);
    @Query("SELECT u FROM User u WHERE TYPE(u) = Learner")
    List<User> findAllLearners();



}

