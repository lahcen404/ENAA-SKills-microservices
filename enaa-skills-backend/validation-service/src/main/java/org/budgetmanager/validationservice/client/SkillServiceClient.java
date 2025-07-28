package org.budgetmanager.validationservice.client;

import org.budgetmanager.validationservice.dto.SkillDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "skill-service", url = "http://localhost:8080")
public interface SkillServiceClient {
    @GetMapping("/skills/{id}")
    SkillDto getSkillById(@PathVariable("id") Long id);
} 