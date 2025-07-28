package org.budgetmanager.validationservice.repository;

import org.budgetmanager.validationservice.Model.SkillValidation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SkillValidationRepository extends JpaRepository<SkillValidation, Long> {
    List<SkillValidation> findBySubmissionId(Long submissionId);
    List<SkillValidation> findBySubSkillId(Long subSkillId);
}
