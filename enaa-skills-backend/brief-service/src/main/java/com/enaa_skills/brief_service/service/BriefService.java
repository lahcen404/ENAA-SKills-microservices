package com.enaa_skills.brief_service.service;


import com.enaa_skills.brief_service.model.Brief;
import java.util.List;
import java.util.Optional;

public interface BriefService {
        Brief createBrief(Brief brief);
        Optional<Brief> getBriefById(Long id);
        List<Brief> getAllBriefs();
        Optional<Brief> updateBrief(Long id, Brief briefDetails);

        boolean deleteBrief(Long id);
        void assignBriefToLearner(Long briefId, Long learnerId); 
}
