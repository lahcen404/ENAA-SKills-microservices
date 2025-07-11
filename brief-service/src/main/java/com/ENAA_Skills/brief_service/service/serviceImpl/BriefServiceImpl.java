package com.ENAA_Skills.brief_service.service.serviceImpl;

import com.ENAA_Skills.brief_service.Feign.BriefInterface;
import com.ENAA_Skills.brief_service.Feign.TrainerInterface;
import com.ENAA_Skills.brief_service.model.Brief;
import com.ENAA_Skills.brief_service.repository.BriefRepository;
import com.ENAA_Skills.brief_service.service.BriefService;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class BriefServiceImpl implements BriefService {

    private final BriefRepository briefRepository;
    private final BriefInterface briefInterface;
    private final TrainerInterface trainerInterface;

    public BriefServiceImpl(BriefRepository briefRepository, BriefInterface briefInterface, TrainerInterface trainerInterface) {
        this.briefRepository = briefRepository;
        this.briefInterface = briefInterface;
        this.trainerInterface = trainerInterface;
    }

    @Override
    public Brief createBrief(Brief brief) {


        try {
            trainerInterface.verifyTrainerExists(brief.getTrainerId());
        } catch (Exception e) {
            throw new RuntimeException("vaalidation failed");
        }

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
