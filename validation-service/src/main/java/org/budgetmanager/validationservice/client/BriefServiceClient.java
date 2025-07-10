package org.budgetmanager.validationservice.client;

import org.budgetmanager.validationservice.dto.BriefDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "brief-service")
public interface BriefServiceClient {
    @GetMapping("/briefs/{id}")
    BriefDto getBriefById(@PathVariable("id") Long id);
} 