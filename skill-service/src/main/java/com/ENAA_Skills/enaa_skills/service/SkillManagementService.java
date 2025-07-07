package com.ENAA_Skills.enaa_skills.service;

import com.ENAA_Skills.enaa_skills.dto.SkillDTO;

import java.util.List;

public interface SkillManagementService {
    SkillDTO createSkill(SkillDTO skillDTO);
    SkillDTO getSkillById(Long id);
    List<SkillDTO> getAllSkills();
    SkillDTO updateSkill(Long id, SkillDTO skillDTO);
    void deleteSkill(Long id);
}
