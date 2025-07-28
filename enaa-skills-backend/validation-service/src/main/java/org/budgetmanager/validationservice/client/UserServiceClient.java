package org.budgetmanager.validationservice.client;

import org.budgetmanager.validationservice.dto.UserDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "user-service", url = "http://localhost:8081")
public interface UserServiceClient {
    @GetMapping("/learners/{id}")
    UserDto getUserById(@PathVariable("id") Long id);
}
