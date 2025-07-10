package com.ENAA_Skills.enaa_skills.mapper;

import com.ENAA_Skills.enaa_skills.dto.SkillDTO;
import com.ENAA_Skills.enaa_skills.dto.SubSkillDTO;
import com.ENAA_Skills.enaa_skills.model.Skill;
import com.ENAA_Skills.enaa_skills.model.SubSkill;
import com.ENAA_Skills.enaa_skills.model.ValidationStatus;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-07-10T12:38:40+0100",
    comments = "version: 1.5.5.Final, compiler: Eclipse JDT (IDE) 3.42.50.v20250628-1110, environment: Java 21.0.7 (Eclipse Adoptium)"
)
@Component
public class SkillMapperImpl implements SkillMapper {

    @Override
    public SkillDTO skillToSkillDTO(Skill skill) {
        if ( skill == null ) {
            return null;
        }

        Long id = null;
        String name = null;
        List<SubSkillDTO> subSkills = null;

        id = skill.getId();
        name = skill.getName();
        subSkills = subSkillListToSubSkillDTOList( skill.getSubSkills() );

        boolean validate = false;

        SkillDTO skillDTO = new SkillDTO( id, name, validate, subSkills );

        return skillDTO;
    }

    @Override
    public SubSkillDTO subSkillToSubSkillDTO(SubSkill subSkill) {
        if ( subSkill == null ) {
            return null;
        }

        Long id = null;
        String name = null;
        String description = null;
        ValidationStatus status = null;

        id = subSkill.getId();
        name = subSkill.getName();
        description = subSkill.getDescription();
        status = subSkill.getStatus();

        SubSkillDTO subSkillDTO = new SubSkillDTO( id, name, description, status );

        return subSkillDTO;
    }

    @Override
    public Skill skillDTOToSkill(SkillDTO skillDTO) {
        if ( skillDTO == null ) {
            return null;
        }

        Skill skill = new Skill();

        skill.setName( skillDTO.getName() );
        skill.setSubSkills( subSkillDTOListToSubSkillList( skillDTO.getSubSkills() ) );

        return skill;
    }

    @Override
    public SubSkill subSkillDTOToSubSkill(SubSkillDTO subSkillDTO) {
        if ( subSkillDTO == null ) {
            return null;
        }

        SubSkill subSkill = new SubSkill();

        subSkill.setId( subSkillDTO.getId() );
        subSkill.setName( subSkillDTO.getName() );
        subSkill.setStatus( subSkillDTO.getStatus() );
        subSkill.setDescription( subSkillDTO.getDescription() );

        return subSkill;
    }

    protected List<SubSkillDTO> subSkillListToSubSkillDTOList(List<SubSkill> list) {
        if ( list == null ) {
            return null;
        }

        List<SubSkillDTO> list1 = new ArrayList<SubSkillDTO>( list.size() );
        for ( SubSkill subSkill : list ) {
            list1.add( subSkillToSubSkillDTO( subSkill ) );
        }

        return list1;
    }

    protected List<SubSkill> subSkillDTOListToSubSkillList(List<SubSkillDTO> list) {
        if ( list == null ) {
            return null;
        }

        List<SubSkill> list1 = new ArrayList<SubSkill>( list.size() );
        for ( SubSkillDTO subSkillDTO : list ) {
            list1.add( subSkillDTOToSubSkill( subSkillDTO ) );
        }

        return list1;
    }
}
