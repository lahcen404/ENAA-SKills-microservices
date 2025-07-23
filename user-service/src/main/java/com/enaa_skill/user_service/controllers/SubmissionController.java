package com.enaa_skill.user_service.controllers;

import com.enaa_skill.user_service.dto.SubmissionRequest;
import com.enaa_skill.user_service.model.Submission;
import com.enaa_skill.user_service.services.SubmissionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


    @RestController
    @RequestMapping("/api/submissions")
    public class SubmissionController {

        private final SubmissionService submissionService;

        public SubmissionController(SubmissionService submissionService) {
            this.submissionService = submissionService;
        }

        @PostMapping
        public ResponseEntity<Submission> createSubmission(@RequestBody SubmissionRequest submissionRequest) {
            Submission submission = submissionService.createSubmission(submissionRequest);
            return ResponseEntity.ok(submission);
        }

        @GetMapping("/{id}")
        public Optional<Submission> getSubmission(@PathVariable Long id) {
            return submissionService.findSubmissionById(id);
        }
    }



