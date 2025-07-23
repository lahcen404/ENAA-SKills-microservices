package com.enaa_skill.user_service.controllers;

import com.enaa_skill.user_service.dto.MessageResponse;
import com.enaa_skill.user_service.dto.RegistrationRequest;
import com.enaa_skill.user_service.model.Learner;
import com.enaa_skill.user_service.model.Trainer;
import com.enaa_skill.user_service.model.User;
import com.enaa_skill.user_service.services.UserService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/learner")
    public ResponseEntity<MessageResponse> registerLearner(@Valid @RequestBody RegistrationRequest registrationRequest) {
        try {
            Learner registeredLearner = userService.registerLearner(registrationRequest);
            if (registeredLearner != null) {
                return ResponseEntity.status(HttpStatus.CREATED)
                        .body(new MessageResponse("Learner " + registeredLearner.getUsername() + " (ID: " + registeredLearner.getId() + ") registered successfully!"));
            } else {
                // Code de secours si jamais `registerLearner` retourne null
                String errorMessage = userService.getValidationErrorMessage();
                return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                        .body(new MessageResponse("Registration failed: " + errorMessage));
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new MessageResponse("An error occurred: " + e.getMessage()));
        }
    }

    @PostMapping("/Trainer")
    public ResponseEntity<MessageResponse> registerTrainer(@Valid @RequestBody RegistrationRequest registrationRequest) {
        try {
            Trainer registeredTrainer = userService.registerTrainer(registrationRequest);
            if (registeredTrainer != null) {
                return ResponseEntity.status(HttpStatus.CREATED)
                        .body(new MessageResponse("Trainer " + registeredTrainer.getUsername() + " (ID: " + registeredTrainer.getId() + ") registered successfully!"));
            } else {
                String errorMessage = userService.getValidationErrorMessage();
                return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                        .body(new MessageResponse("Registration failed: " + errorMessage));
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new MessageResponse("An error occurred: " + e.getMessage()));
            Optional<Learner> registeredLearnerOptional = Optional.ofNullable(userService.registerLearner(registrationRequest));

            if (registeredLearnerOptional.isPresent()) {
                Learner registeredLearner = registeredLearnerOptional.get();
                return ResponseEntity.status(HttpStatus.CREATED)
                        .body(new MessageResponse("Learner " + registeredLearner.getUsername() + " (ID: " + registeredLearner.getId() + ") registered successfully!"));
            } else {
                String errorMessage = userService.getValidationErrorMessage(); // Get the specific error message
                return ResponseEntity.badRequest().body(new MessageResponse(errorMessage != null ? errorMessage : "Registration failed due to invalid input."));
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new MessageResponse("An unexpected error occurred during registration: " + e.getMessage()));
        }
    }
    @PostMapping("/Trainer")
    public ResponseEntity<MessageResponse> registerTrainer(@Valid @RequestBody RegistrationRequest registrationRequest) {
        try {
            Optional<Trainer> registeredTrainerOptional = Optional.ofNullable(userService.registerTrainer(registrationRequest));

            if (registeredTrainerOptional.isPresent()) {
                Trainer registeredTrainer = registeredTrainerOptional.get();
                return ResponseEntity.status(HttpStatus.CREATED)
                        .body(new MessageResponse("Trainer " + registeredTrainer.getUsername() + " (ID: " + registeredTrainer.getId() + ") registered successfully!"));
            } else {
                String errorMessage = userService.getValidationErrorMessage(); // Get the specific error message
                return ResponseEntity.badRequest().body(new MessageResponse(errorMessage != null ? errorMessage : "Registration failed due to invalid input."));
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new MessageResponse("An unexpected error occurred during registration: " + e.getMessage()));
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> checkUserExists(@PathVariable Long id) {
        Optional<User> userOptional = userService.getUserById(id);
        return userOptional.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());

    }

}
