package com.ENAA_Skills.enaa_skills.mapper;

import com.ENAA_Skills.enaa_skills.dto.LearnerDTO;
import com.ENAA_Skills.enaa_skills.model.Learner;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface LearnerMapper {
    LearnerDTO learnerToLearnerDTO(Learner learner);
    Learner learnerDTOToLearner(LearnerDTO learnerDTO);
}
