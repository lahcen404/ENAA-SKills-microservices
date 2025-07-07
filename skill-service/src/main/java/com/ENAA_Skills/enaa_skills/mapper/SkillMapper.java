package com.ENAA_Skills.enaa_skills.mapper;

import com.ENAA_Skills.enaa_skills.dto.SkillDTO;
import com.ENAA_Skills.enaa_skills.dto.SubSkillDTO;
import com.ENAA_Skills.enaa_skills.model.Skill;
import com.ENAA_Skills.enaa_skills.model.SubSkill;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface SkillMapper {
    @Mapping(target = "validate", ignore = true)
    SkillDTO skillToSkillDTO(Skill skill);

    SubSkillDTO subSkillToSubSkillDTO(SubSkill subSkill);

    @Mapping(target = "id", ignore = true)
    Skill skillDTOToSkill(SkillDTO skillDTO);

    SubSkill subSkillDTOToSubSkill(SubSkillDTO subSkillDTO);
}

