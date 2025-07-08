package com.ENAA_Skills.enaa_skills.mapper;

import com.ENAA_Skills.enaa_skills.dto.LearnerDTO;
import com.ENAA_Skills.enaa_skills.model.Learner;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-07-08T00:15:39+0100",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 23.0.1 (Oracle Corporation)"
)
@Component
public class LearnerMapperImpl implements LearnerMapper {

    @Override
    public LearnerDTO learnerToLearnerDTO(Learner learner) {
        if ( learner == null ) {
            return null;
        }

        LearnerDTO learnerDTO = new LearnerDTO();

        learnerDTO.setId( learner.getId() );
        learnerDTO.setName( learner.getName() );
        learnerDTO.setEmail( learner.getEmail() );

        return learnerDTO;
    }

    @Override
    public Learner learnerDTOToLearner(LearnerDTO learnerDTO) {
        if ( learnerDTO == null ) {
            return null;
        }

        Learner learner = new Learner();

        learner.setName( learnerDTO.getName() );
        learner.setEmail( learnerDTO.getEmail() );
        learner.setId( learnerDTO.getId() );

        return learner;
    }
}
