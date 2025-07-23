package com.enaa_skills.enaa_skills.controller;

import com.enaa_skills.enaa_skills.dto.LearnerDTO;
import com.enaa_skills.enaa_skills.service.LearnerService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/learners")
public class LearnerController {

    private final LearnerService learnerService;

    @Autowired
    public LearnerController(LearnerService learnerService) {
        this.learnerService = learnerService;
    }

    @PostMapping
    public ResponseEntity<LearnerDTO> createLearner(@Valid @RequestBody LearnerDTO learnerDTO) {
        return new ResponseEntity<>(learnerService.createLearner(learnerDTO), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<LearnerDTO> getLearnerById(@PathVariable Long id) {
        return ResponseEntity.ok(learnerService.getLearnerById(id));
    }

    @GetMapping
    public ResponseEntity<List<LearnerDTO>> getAllLearners() {
        return ResponseEntity.ok(learnerService.getAllLearners());
    }

    @PutMapping("/{id}")
    public ResponseEntity<LearnerDTO> updateLearner(@PathVariable Long id, @Valid @RequestBody LearnerDTO learnerDTO) {
        return ResponseEntity.ok(learnerService.updateLearner(id, learnerDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLearner(@PathVariable Long id) {
        learnerService.deleteLearner(id);
        return ResponseEntity.noContent().build();
    }
}
