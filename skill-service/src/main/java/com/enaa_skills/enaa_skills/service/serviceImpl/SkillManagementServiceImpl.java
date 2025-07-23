package com.enaa_skills.enaa_skills.service.serviceImpl;

import com.enaa_skills.enaa_skills.dto.SkillDTO;
import com.enaa_skills.enaa_skills.dto.SubSkillDTO;
import com.enaa_skills.enaa_skills.mapper.SkillMapper;
import com.enaa_skills.enaa_skills.model.Skill;
import com.enaa_skills.enaa_skills.model.SubSkill;
import com.enaa_skills.enaa_skills.model.ValidationStatus;
import com.enaa_skills.enaa_skills.repository.SkillRepository;
import com.enaa_skills.enaa_skills.repository.SubSkillRepository;
import com.enaa_skills.enaa_skills.service.SkillManagementService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SkillManagementServiceImpl implements SkillManagementService {

    private final SkillRepository skillRepository;
    private final SkillMapper skillMapper;
    private final SubSkillRepository subSkillRepository;

    public SkillManagementServiceImpl(SkillRepository skillRepository, SkillMapper skillMapper, SubSkillRepository subSkillRepository) {
        this.skillRepository = skillRepository;
        this.skillMapper = skillMapper;
        this.subSkillRepository = subSkillRepository;
    }


    @Override
    public SkillDTO createSkill(SkillDTO skillDTO) {
        Skill skill = skillMapper.skillDTOToSkill(skillDTO);
        if (skill.getSubSkills() != null) {
            for (SubSkill subSkill : skill.getSubSkills()) {
                subSkill.setSkill(skill);
                subSkill.setStatus(ValidationStatus.NOT_VALIDATE);
            }
        }
        Skill savedSkill = skillRepository.save(skill);
        return convertToDtoWithValidateStatus(savedSkill);
    }

    private SkillDTO convertToDtoWithValidateStatus(Skill skill) {
        // entity to  DTO
        SkillDTO dto = skillMapper.skillToSkillDTO(skill);

        if (skill.getSubSkills() == null || skill.getSubSkills().isEmpty()) {
            dto.setValidate(false);
            return dto;
        }

        // count  validate subSkills
        int validatedCount = 0;
        for (SubSkill subSkill : skill.getSubSkills()) {
            if (subSkill.getStatus() == ValidationStatus.VALIDATE) {
                validatedCount++;
            }
        }

        boolean isValidate = validatedCount > (skill.getSubSkills().size() / 2.0);
        dto.setValidate(isValidate);

        return dto;
    }

    @Override
    public SkillDTO getSkillById(Long id) {
        Skill skill = skillRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("skill not found"));

        return convertToDtoWithValidateStatus(skill);
    }

    @Override
    public List<SkillDTO> getAllSkills() {
        return skillRepository.findAll().stream()
                .map(this::convertToDtoWithValidateStatus)
                .collect(Collectors.toList());    }

    @Override
    public SkillDTO updateSkill(Long id, SkillDTO skillDTO) {
       Skill existingSkill = skillRepository.findById(id)
               .orElseThrow(() -> new RuntimeException("skill not found "));

       existingSkill.setName(skillDTO.getName());

       for(SubSkillDTO subSkillDTO : skillDTO.getSubSkills()){
           SubSkill existingSubSkill = subSkillRepository.findById(subSkillDTO.getId())
                   .orElseThrow(() -> new RuntimeException("skill not found "));

           existingSubSkill.setName(subSkillDTO.getName());
           existingSubSkill.setStatus(subSkillDTO.getStatus());
           existingSubSkill.setDescription(subSkillDTO.getDescription());
       }

       Skill updatedSkill = skillRepository.save(existingSkill);
        return convertToDtoWithValidateStatus(updatedSkill);
    }

    @Override
    public void deleteSkill(Long id) {
        Skill deletedSkill = skillRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("skill not found "));

        skillRepository.delete(deletedSkill);
    }


}
