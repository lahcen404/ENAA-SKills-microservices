package com.enaa_skills.brief_service.controller;

import com.enaa_skills.brief_service.model.Brief;
import com.enaa_skills.brief_service.service.BriefService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/briefs")
public class BriefController {

    private final BriefService briefService;

    @Autowired
    public BriefController(BriefService briefService) {
        this.briefService = briefService;
    }

    @PostMapping
    public ResponseEntity<Brief> createBrief(@RequestBody Brief brief) {
        Brief createdBrief = briefService.createBrief(brief);
        return new ResponseEntity<>(createdBrief, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Brief> getBriefById(@PathVariable Long id) {
        Optional<Brief> brief = briefService.getBriefById(id);
        return brief.map(ResponseEntity::ok)
                    .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @GetMapping
    public ResponseEntity<List<Brief>> getAllBriefs() {
        List<Brief> briefs = briefService.getAllBriefs();
        return ResponseEntity.ok(briefs);
    }

     @PutMapping("/{id}")
    public ResponseEntity<Brief> updateBrief(@PathVariable Long id, @RequestBody Brief briefDetails) {
        Optional<Brief> updatedBrief = briefService.updateBrief(id, briefDetails);
        return updatedBrief
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    // ✅ DELETE /briefs/{id}
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBrief(@PathVariable Long id) {
        boolean deleted = briefService.deleteBrief(id);
        return deleted
                ? ResponseEntity.noContent().build()
                : ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @PostMapping("/{briefId}/assign")
    public ResponseEntity<Void> assignBrief(@PathVariable Long briefId, @RequestBody Long learnerId) {
        try {
            briefService.assignBriefToLearner(briefId, learnerId);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            // Handle cases where brief or learner is not found
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
