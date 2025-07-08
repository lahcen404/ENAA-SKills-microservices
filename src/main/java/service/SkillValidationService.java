package service;


import Model.SkillValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.SkillValidationRepository;

import java.util.List;

@Service
public class SkillValidationService {

    @Autowired
    private SkillValidationRepository repository;

    public SkillValidation ajouter(SkillValidation validation) {
        return repository.save(validation);
    }

    public List<SkillValidation> getBySubmissionId(Long id) {
        return repository.findBySubmissionId(id);
    }

    public List<SkillValidation> getBySubSkillId(Long id) {
        return repository.findBySubSkillId(id);
    }

    public List<SkillValidation> getAll() {
        return repository.findAll();
    }
}
