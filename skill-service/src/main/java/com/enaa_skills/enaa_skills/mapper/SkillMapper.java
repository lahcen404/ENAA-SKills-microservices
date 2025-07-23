package com.enaa_skills.enaa_skills.mapper;

import com.enaa_skills.enaa_skills.dto.SkillDTO;
import com.enaa_skills.enaa_skills.dto.SubSkillDTO;
import com.enaa_skills.enaa_skills.model.Skill;
import com.enaa_skills.enaa_skills.model.SubSkill;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface SkillMapper {
    @Mapping(target = "validate", ignore = true)
    SkillDTO skillToSkillDTO(Skill skill);

    SubSkillDTO subSkillToSubSkillDTO(SubSkill subSkill);

    @Mapping(target = "id", ignore = true)
    Skill skillDTOToSkill(SkillDTO skillDTO);

    SubSkill subSkillDTOToSubSkill(SubSkillDTO subSkillDTO);
}

