package com.enaa_skills.brief_service.feign;

import com.enaa_skills.brief_service.dto.SkillDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "skill-service" )
public interface BriefInterface {

    @GetMapping("skills/{id}")
    public ResponseEntity<SkillDTO> getSkillById(@PathVariable Long id) ;

    @GetMapping("skills")
    public ResponseEntity<List<SkillDTO>> getAllSkills();
}
