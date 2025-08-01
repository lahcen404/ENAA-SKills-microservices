package com.enaa_skills.brief_service.service.serviceImpl;
import com.enaa_skills.brief_service.model.Brief;
import com.enaa_skills.brief_service.repository.BriefRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@Service
public class BriefService {

    private final BriefRepository briefRepository;
    private final RestTemplate restTemplate;

    // This gets the user service URL from your application.properties
    @Value("${user.service.url}")
    private String userServiceUrl;

    @Autowired
    public BriefService(BriefRepository briefRepository, RestTemplate restTemplate) {
        this.briefRepository = briefRepository;
        this.restTemplate = restTemplate;
    }

    public Brief createBrief(Brief brief) {
        return briefRepository.save(brief);
    }

    public Optional<Brief> getBriefById(Long id) {
        return briefRepository.findById(id);
    }

    public List<Brief> getAllBriefs() {
        return briefRepository.findAll();
    }

    public Optional<Brief> updateBrief(Long id, Brief briefDetails) {
        return briefRepository.findById(id).map(brief -> {
            brief.setTitle(briefDetails.getTitle());
            // Add other fields to update as needed
            return briefRepository.save(brief);
        });
    }

    public boolean deleteBrief(Long id) {
        if (briefRepository.existsById(id)) {
            briefRepository.deleteById(id);
            return true;
        }
        return false;
    }

    // --- ASSIGNMENT LOGIC ADDED HERE ---
    public void assignBriefToLearner(Long briefId, Long learnerId) {
        // 1. Verify the learner exists by calling the UserService
        try {
            // This makes a GET request to http://localhost:PORT/api/users/{learnerId}
            restTemplate.getForObject(userServiceUrl + "/" + learnerId, Object.class);
        } catch (Exception e) {
            throw new RuntimeException("Learner not found with id: " + learnerId);
        }

        // 2. Find the brief
        Brief brief = briefRepository.findById(briefId)
                .orElseThrow(() -> new RuntimeException("Brief not found with id: " + briefId));

        // 3. Set the learnerId on the brief and save it
        brief.setLearnerId(learnerId);
        briefRepository.save(brief);
    }
}