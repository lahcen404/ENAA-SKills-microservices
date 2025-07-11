package com.ENAA_Skill.user_service.controllers;

import com.ENAA_Skill.user_service.dto.MessageResponse;
import com.ENAA_Skill.user_service.dto.RegistrationRequest;
import com.ENAA_Skill.user_service.model.Learner;
import com.ENAA_Skill.user_service.model.Trainer;
import com.ENAA_Skill.user_service.model.User;
import com.ENAA_Skill.user_service.services.UserService;
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
    public ResponseEntity<?> registerLearner(@Valid @RequestBody RegistrationRequest registrationRequest) {
        try {
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
    public ResponseEntity<?> registerTrainer(@Valid @RequestBody RegistrationRequest registrationRequest) {
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
    public Optional<User> checkUserExists(@PathVariable Long id){
       return userService.getUserById(id);
    }


//    @GetMapping("/{id}/verify-trainer")
//    public ResponseEntity<Void> verifyTrainerExists(@PathVariable Long id) {
//        userService.findUserByIdAndRole(id, "Trainer");
//        return ResponseEntity.ok().build();
//    }
}
