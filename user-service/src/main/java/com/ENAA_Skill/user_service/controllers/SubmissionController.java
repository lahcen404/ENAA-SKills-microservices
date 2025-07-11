package com.ENAA_Skill.user_service.controllers;

import com.ENAA_Skill.user_service.dto.SubmissionRequest;
import com.ENAA_Skill.user_service.model.Submission;
import com.ENAA_Skill.user_service.services.SubmissionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/submissions")
public class SubmissionController {

    private final SubmissionService submissionService;

    public SubmissionController(SubmissionService submissionService) {
        this.submissionService = submissionService;
    }
    @RestController
    @RequestMapping("/api/submissions")
    public class submissionController {

        private final SubmissionService submissionService;

        public submissionController(SubmissionService submissionService) {
            this.submissionService = submissionService;
        }

        @PostMapping
        public ResponseEntity<Submission> createSubmission(@RequestBody SubmissionRequest submissionRequest) {
            Submission submission = submissionService.createSubmission(submissionRequest);
            return ResponseEntity.ok(submission);
        }
    }

    @GetMapping("/{id}")
    public Optional<Submission> getSubmission(@PathVariable Long id) {
        return submissionService.findSubmissionById(id);
    }
}
