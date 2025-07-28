package com.enaa_skills.enaa_skills.mapper;

import com.enaa_skills.enaa_skills.dto.LearnerDTO;
import com.enaa_skills.enaa_skills.model.Learner;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface LearnerMapper {
    LearnerDTO learnerToLearnerDTO(Learner learner);
    Learner learnerDTOToLearner(LearnerDTO learnerDTO);
}
