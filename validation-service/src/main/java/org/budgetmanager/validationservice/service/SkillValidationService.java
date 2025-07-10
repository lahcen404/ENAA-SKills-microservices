package org.budgetmanager.validationservice.service;

import org.budgetmanager.validationservice.Model.SkillValidation;
import org.budgetmanager.validationservice.repository.SkillValidationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.budgetmanager.validationservice.client.UserServiceClient;

import java.util.List;

@Service
public class SkillValidationService {
    private final SkillValidationRepository repository;
    private final UserServiceClient userServiceClient;

    @Autowired
    public SkillValidationService(SkillValidationRepository repository, UserServiceClient userServiceClient) {
        this.repository = repository;
        this.userServiceClient = userServiceClient;
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

    // You can add methods here to use userServiceClient when user-service endpoint is available
}

