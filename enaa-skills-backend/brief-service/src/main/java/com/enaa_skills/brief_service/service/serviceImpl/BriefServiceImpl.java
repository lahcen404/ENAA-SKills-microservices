package com.enaa_skills.brief_service.service.serviceImpl;

import com.enaa_skills.brief_service.feign.BriefInterface;
import com.enaa_skills.brief_service.model.Brief;
import com.enaa_skills.brief_service.repository.BriefRepository;
import com.enaa_skills.brief_service.service.BriefService;
import org.springframework.stereotype.Service;

import java.util.Optional;


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

    @Override
    public Optional<Brief> getBriefById(Long id) {
        return briefRepository.findById(id);
    }


}
