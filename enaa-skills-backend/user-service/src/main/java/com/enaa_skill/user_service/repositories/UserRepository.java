package com.enaa_skill.user_service.repositories;


import com.enaa_skill.user_service.model.Learner;
import com.enaa_skill.user_service.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;
 import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User, Long> {
    boolean existsByEmail(String email);
    Optional<User> findById(Long id);
  

   @Query("SELECT l FROM Learner l")
   List<Learner> findAllLearners(); 

    

}

