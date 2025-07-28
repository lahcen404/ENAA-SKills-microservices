package org.budgetmanager.validationservice.Controller;

import org.budgetmanager.validationservice.Model.SkillValidation;
import org.budgetmanager.validationservice.service.SkillValidationService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import org.budgetmanager.validationservice.dto.UserDto;
import org.budgetmanager.validationservice.dto.SkillDto;
import org.budgetmanager.validationservice.dto.BriefDto;

@RestController
@RequestMapping("/skillvalidations")
@CrossOrigin(origins = "*")
public class SkillValidationController {

    private final SkillValidationService service;

    public SkillValidationController(SkillValidationService service) {
        this.service = service;
    }

    @PostMapping
    public SkillValidation ajouterValidation(@RequestBody SkillValidation validation) {
        return service.ajouter(validation);
    }

    @GetMapping
    public List<SkillValidation> getAll() {
        return service.getAll();
    }

    @GetMapping("/submission/{id}")
    public List<SkillValidation> getBySubmission(@PathVariable Long id) {
        return service.getBySubmissionId(id);
    }

    @GetMapping("/subskill/{id}")
    public List<SkillValidation> getBySubSkill(@PathVariable Long id) {
        return service.getBySubSkillId(id);
    }

    @GetMapping("/user/{userId}")
    public UserDto getUser(@PathVariable Long userId) {
        return service.getUser(userId);
    }

    @GetMapping("/skill/{skillId}")
    public SkillDto getSkill(@PathVariable Long skillId) {
        return service.getSkill(skillId);
    }

    @GetMapping("/brief/{briefId}")
    public BriefDto getBrief(@PathVariable Long briefId) {
        return service.getBrief(briefId);
    }
}


