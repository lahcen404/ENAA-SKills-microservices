package com.enaa_skills.enaa_skills.service.serviceImpl;

import com.enaa_skills.enaa_skills.dto.LearnerDTO;
import com.enaa_skills.enaa_skills.mapper.LearnerMapper;
import com.enaa_skills.enaa_skills.model.Learner;
import com.enaa_skills.enaa_skills.repository.LearnerRepository;
import com.enaa_skills.enaa_skills.service.LearnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LearnerServiceImpl implements LearnerService {

    private final LearnerRepository learnerRepository;
    private final LearnerMapper learnerMapper;


    @Autowired
    public LearnerServiceImpl(LearnerRepository learnerRepository, LearnerMapper learnerMapper) {
        this.learnerRepository = learnerRepository;
        this.learnerMapper = learnerMapper;
    }

    @Override
    public LearnerDTO createLearner(LearnerDTO learnerDTO) {
        Learner learner = learnerMapper.learnerDTOToLearner(learnerDTO);
        Learner savedLearner = learnerRepository.save(learner);
        return learnerMapper.learnerToLearnerDTO(savedLearner);
    }

    @Override
    public LearnerDTO getLearnerById(Long id) {
        Learner learner = learnerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Learner not found"));
        return learnerMapper.learnerToLearnerDTO(learner);
    }

    @Override
    public List<LearnerDTO> getAllLearners() {
        return learnerRepository.findAll()
                .stream()
                .map(learnerMapper::learnerToLearnerDTO)
                .collect(Collectors.toList());
    }

    @Override
    public LearnerDTO updateLearner(Long id, LearnerDTO learnerDTO) {
        Learner existingLearner = learnerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Learner not found " ));

        existingLearner.setName(learnerDTO.getName());
        existingLearner.setEmail(learnerDTO.getEmail());

        Learner savedLearner = learnerRepository.save(existingLearner);
        return learnerMapper.learnerToLearnerDTO(savedLearner);
    }

    @Override
    public void deleteLearner(Long id) {
        learnerRepository.deleteById(id);
    }
}