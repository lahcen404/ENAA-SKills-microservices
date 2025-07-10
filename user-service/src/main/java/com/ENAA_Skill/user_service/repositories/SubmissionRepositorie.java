package com.ENAA_Skill.user_service.repositories;

import com.ENAA_Skill.user_service.model.Submission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubmissionRepositorie extends JpaRepository<Submission, Long> {

}
