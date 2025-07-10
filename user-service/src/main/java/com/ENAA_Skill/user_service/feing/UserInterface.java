package com.ENAA_Skill.user_service.feing;

import com.ENAA_Skills.brief_service.model.Brief;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;
@FeignClient(name = "brief-service", url = "http://localhost:8081")
public interface UserInterface {

    @GetMapping("/briefs/{id}") // adapte en fonction du mapping réel du service brief
    Optional<Brief> getBriefById(@PathVariable("id") Long id);
}
