package com.enaa_skill.user_service.services;

import com.enaa_skill.user_service.dto.RegistrationRequest;
import com.enaa_skill.user_service.model.Learner;
import com.enaa_skill.user_service.model.Trainer;
import com.enaa_skill.user_service.model.User;
import com.enaa_skill.user_service.repositories.UserRepositorie;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

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

    @Transactional
    public Trainer registerTrainer(RegistrationRequest request){


        Trainer trainer = new Trainer();
        trainer.setUsername(request.getUsername());
        trainer.setEmail(request.getEmail());
        trainer.setPassword(request.getPassword());

        return userRepositorie.save(trainer);
    }

    public Optional<User> getUserById(Long id){
        return userRepositorie.findById(id);
    }


    public String getValidationErrorMessage() {
        return "Invalid username or password";
    }
}

