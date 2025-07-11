package com.ENAA_Skills.brief_service.Feign;

import com.ENAA_Skills.brief_service.dto.TrainerDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@FeignClient(name = "user-service", url = "${USER_SERVICE_URL}")
public interface TrainerInterface {
    @GetMapping("/{id}/verify-trainer")
    public ResponseEntity<Void> verifyTrainerExists(@PathVariable Long id);
}
