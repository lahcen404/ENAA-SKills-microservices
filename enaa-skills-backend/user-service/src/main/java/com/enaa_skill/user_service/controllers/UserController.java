package com.enaa_skill.user_service.controllers;

import com.enaa_skill.user_service.dto.MessageResponse;
import com.enaa_skill.user_service.dto.RegistrationRequest;
import com.enaa_skill.user_service.model.Learner;
import com.enaa_skill.user_service.model.Trainer;
import com.enaa_skill.user_service.model.User;

import com.enaa_skill.user_service.services.UserServiceImpl;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserServiceImpl userService;

    public UserController(UserServiceImpl userService) {
        this.userService = userService;
    }

    @PostMapping("/learner")
    public ResponseEntity<MessageResponse> registerLearner(@Valid @RequestBody RegistrationRequest registrationRequest) {
        try {
            Learner registeredLearner = userService.registerLearner(registrationRequest);
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(new MessageResponse("Learner " + registeredLearner.getUsername() + " (ID: " + registeredLearner.getId() + ") registered successfully!"));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new MessageResponse("An error occurred: " + e.getMessage()));
        }
    }

    @PostMapping("/trainer")
    public ResponseEntity<MessageResponse> registerTrainer(@Valid @RequestBody RegistrationRequest registrationRequest) {
        try {
            Trainer registeredTrainer = userService.registerTrainer(registrationRequest);
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(new MessageResponse("Trainer " + registeredTrainer.getUsername() + " (ID: " + registeredTrainer.getId() + ") registered successfully!"));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new MessageResponse("An error occurred: " + e.getMessage()));
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        Optional<User> userOptional = userService.getUserById(id);
        return userOptional.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/learners")
    public ResponseEntity<List<Learner>> getAllLearners() {
        List<Learner> learners = userService.getAllLearners();
        return ResponseEntity.ok(learners);
    }
}
