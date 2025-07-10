package org.budgetmanager.validationservice.service;

import org.budgetmanager.validationservice.Model.SkillValidation;
import org.budgetmanager.validationservice.repository.SkillValidationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.budgetmanager.validationservice.client.UserServiceClient;
import org.budgetmanager.validationservice.client.SkillServiceClient;
import org.budgetmanager.validationservice.client.BriefServiceClient;
import org.budgetmanager.validationservice.dto.UserDto;
import org.budgetmanager.validationservice.dto.SkillDto;
import org.budgetmanager.validationservice.dto.BriefDto;

import java.util.List;

@Service
public class SkillValidationService {
    private final SkillValidationRepository repository;
    private final UserServiceClient userServiceClient;
    private final SkillServiceClient skillServiceClient;
    private final BriefServiceClient briefServiceClient;

    @Autowired
    public SkillValidationService(SkillValidationRepository repository, UserServiceClient userServiceClient, SkillServiceClient skillServiceClient, BriefServiceClient briefServiceClient) {
        this.repository = repository;
        this.userServiceClient = userServiceClient;
        this.skillServiceClient = skillServiceClient;
        this.briefServiceClient = briefServiceClient;
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

    public UserDto getUser(Long userId) {
        return userServiceClient.getUserById(userId);
    }

    public SkillDto getSkill(Long skillId) {
        return skillServiceClient.getSkillById(skillId);
    }

    public BriefDto getBrief(Long briefId) {
        return briefServiceClient.getBriefById(briefId);
    }

    // You can add methods here to use userServiceClient when user-service endpoint is available
}

