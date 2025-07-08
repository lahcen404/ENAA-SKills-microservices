package com.ENAA_Skills.brief_service.service.serviceImpl;

import com.ENAA_Skills.brief_service.Feign.BriefInterface;
import com.ENAA_Skills.brief_service.model.Brief;
import com.ENAA_Skills.brief_service.repository.BriefRepository;
import com.ENAA_Skills.brief_service.service.BriefService;
import org.springframework.stereotype.Service;


@Service
public class BriefServiceImpl implements BriefService {

    private final BriefRepository briefRepository;
    private final BriefInterface briefInterface;

    public BriefServiceImpl(BriefRepository briefRepository, BriefInterface briefInterface) {
        this.briefRepository = briefRepository;
        this.briefInterface = briefInterface;
    }

    @Override
    public Brief createBrief(Brief brief) {

        if (brief.getSkillIds() != null && !brief.getSkillIds().isEmpty()) {
            for (Long skillId : brief.getSkillIds()) {
                briefInterface.getSkillById(skillId);
            }
        }

        return briefRepository.save(brief);
    }
}
