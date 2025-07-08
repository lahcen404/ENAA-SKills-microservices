package com.ENAA_Skills.brief_service.controller;

import com.ENAA_Skills.brief_service.model.Brief;
import com.ENAA_Skills.brief_service.service.BriefService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
