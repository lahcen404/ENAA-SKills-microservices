package org.budgetmanager.validationservice.service;

import org.budgetmanager.validationservice.Model.SkillValidation;
import org.budgetmanager.validationservice.repository.SkillValidationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SkillValidationService {
    private final SkillValidationRepository repository;

    public SkillValidationService(SkillValidationRepository repository) {
        this.repository = repository;
    }

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

