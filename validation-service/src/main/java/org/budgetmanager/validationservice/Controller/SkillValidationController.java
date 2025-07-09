package org.budgetmanager.validationservice.Controller;

import org.budgetmanager.validationservice.Model.SkillValidation;
import org.budgetmanager.validationservice.service.SkillValidationService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
}


