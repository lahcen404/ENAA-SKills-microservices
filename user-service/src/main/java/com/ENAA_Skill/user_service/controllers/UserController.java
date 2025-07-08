package com.ENAA_Skill.user_service.controllers;

import com.ENAA_Skill.user_service.dto.MessageResponse;
import com.ENAA_Skill.user_service.dto.RegistrationRequest;
import com.ENAA_Skill.user_service.model.Learner;
import com.ENAA_Skill.user_service.services.UserService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
                // If Optional is empty, it means validation failed in the service
                String errorMessage = userService.getValidationErrorMessage(); // Get the specific error message
                return ResponseEntity.badRequest().body(new MessageResponse(errorMessage != null ? errorMessage : "Registration failed due to invalid input."));
            }
        } catch (Exception e) {
            // This catch block is for truly unexpected, system-level errors
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new MessageResponse("An unexpected error occurred during registration: " + e.getMessage()));
        }
    }
}
