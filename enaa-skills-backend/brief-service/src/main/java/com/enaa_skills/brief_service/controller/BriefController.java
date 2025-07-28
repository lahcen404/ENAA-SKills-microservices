package com.enaa_skills.brief_service.controller;

import com.enaa_skills.brief_service.model.Brief;
import com.enaa_skills.brief_service.service.BriefService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    public Optional<Brief> getBriefById(@PathVariable Long id){
        return briefService.getBriefById(id);
    }
}
