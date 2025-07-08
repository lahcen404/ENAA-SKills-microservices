package com.ENAA_Skill.user_service.services;

import com.ENAA_Skill.user_service.dto.RegistrationRequest;
import com.ENAA_Skill.user_service.model.Learner;
import com.ENAA_Skill.user_service.repositories.UserRepositorie;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {

    private final UserRepositorie userRepositorie;

    public UserService(UserRepositorie userRepositorie) {
        this.userRepositorie = userRepositorie;
    }

    @Transactional
    public Learner registerLearner(RegistrationRequest request){


        Learner learner = new Learner();
        learner.setUsername(request.getUsername());
        learner.setEmail(request.getEmail());
        learner.setPassword(request.getPassword());

        return userRepositorie.save(learner);
    }

    public String getValidationErrorMessage() {
        return "Invalid username or password";
    }
}

