package com.ENAA_Skill.user_service.controllers;

import com.ENAA_Skill.user_service.dto.SubmissionRequest;
import com.ENAA_Skill.user_service.model.Submission;
import com.ENAA_Skill.user_service.services.SubmissionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/submissions")
public class SubmissionController {

    private final SubmissionService submissionService;

    public SubmissionController(SubmissionService submissionService) {
        this.submissionService = submissionService;
    }

    @PostMapping
    public ResponseEntity<?> createSubmission(@RequestBody SubmissionRequest submissionRequest) {
        try {
            Submission submission = submissionService.createSubmission(submissionRequest);
            if (submission != null) {
                return new ResponseEntity<>(submission, HttpStatus.CREATED);
            } else {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
