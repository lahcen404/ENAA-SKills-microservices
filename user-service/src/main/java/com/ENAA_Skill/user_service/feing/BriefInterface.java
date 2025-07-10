package com.ENAA_Skill.user_service.feing;

import com.ENAA_Skills.brief_service.dto.SkillDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "skill-service", url = "http://localhost:8083")
public interface BriefInterface {

    @GetMapping("skills/{id}")
    public ResponseEntity<SkillDTO> getSkillById(@PathVariable Long id) ;

    @GetMapping("skills")
    public ResponseEntity<List<SkillDTO>> getAllSkills();
}
