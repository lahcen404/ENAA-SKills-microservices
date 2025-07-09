package repository;

import com.enaa.validationservice.model.SkillValidation;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface SkillValidationRepository extends JpaRepository<SkillValidation, Long> {
    List<SkillValidation> findBySubmissionId(Long submissionId);
    List<SkillValidation> findBySubSkillId(Long subSkillId);
}
