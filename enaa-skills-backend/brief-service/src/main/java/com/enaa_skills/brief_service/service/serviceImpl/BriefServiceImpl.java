// Correct file path should be: .../service/serviceImpl/BriefServiceImpl.java
package com.enaa_skills.brief_service.service.serviceImpl;

import com.enaa_skills.brief_service.model.Brief;
import com.enaa_skills.brief_service.repository.BriefRepository;
import com.enaa_skills.brief_service.service.BriefService; // Import the interface
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@Service
public class BriefServiceImpl implements BriefService { // <- FIX: Rename class and add "implements BriefService"

    private final BriefRepository briefRepository;
    private final RestTemplate restTemplate;

    @Value("${user.service.url}")
    private String userServiceUrl;

    @Autowired
    public BriefServiceImpl(BriefRepository briefRepository, RestTemplate restTemplate) { // <- FIX: Rename constructor
        this.briefRepository = briefRepository;
        this.restTemplate = restTemplate;
    }

    @Override
    public Brief createBrief(Brief brief) {
        return briefRepository.save(brief);
    }

    @Override
    public Optional<Brief> getBriefById(Long id) {
        return briefRepository.findById(id);
    }

    @Override
    public List<Brief> getAllBriefs() {
        return briefRepository.findAll();
    }

    @Override
    public Optional<Brief> updateBrief(Long id, Brief briefDetails) {
        return briefRepository.findById(id).map(brief -> {
            brief.setTitle(briefDetails.getTitle());
            return briefRepository.save(brief);
        });
    }

    @Override
    public boolean deleteBrief(Long id) {
        if (briefRepository.existsById(id)) {
            briefRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public void assignBriefToLearner(Long briefId, Long learnerId) {
        try {
            restTemplate.getForObject(userServiceUrl + "/" + learnerId, Object.class);
        } catch (Exception e) {
            throw new RuntimeException("Learner not found with id: " + learnerId);
        }
        Brief brief = briefRepository.findById(briefId)
                .orElseThrow(() -> new RuntimeException("Brief not found with id: " + briefId));
        brief.setLearnerId(learnerId);
        briefRepository.save(brief);
    }
}