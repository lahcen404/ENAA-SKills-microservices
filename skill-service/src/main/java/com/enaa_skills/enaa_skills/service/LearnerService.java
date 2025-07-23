package com.enaa_skills.enaa_skills.service;

import com.enaa_skills.enaa_skills.dto.LearnerDTO;

import java.util.List;

public interface LearnerService {
    LearnerDTO createLearner(LearnerDTO learnerDTO);
    LearnerDTO getLearnerById(Long id);
    LearnerDTO updateLearner(Long id, LearnerDTO learnerDTO);
    List<LearnerDTO> getAllLearners();
    void deleteLearner(Long id);
}
