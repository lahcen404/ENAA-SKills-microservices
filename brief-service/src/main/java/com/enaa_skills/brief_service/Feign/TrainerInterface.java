package com.enaa_skills.brief_service.Feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@FeignClient(name = "user-service")
public interface TrainerInterface {
    @GetMapping("/{id}/verify-trainer")
    public ResponseEntity<Void> verifyTrainerExists(@PathVariable Long id);
}
