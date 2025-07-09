package Controller;

import com.enaa.validationservice.model.SkillValidation;
import com.enaa.validationservice.service.SkillValidationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/skillvalidations")
@CrossOrigin(origins = "*") // optionnel pour autoriser les appels dlfront
public class SkillValidationController {

    @Autowired
    private SkillValidationService service;

    // add validation
    @PostMapping
    public SkillValidation ajouterValidation(@RequestBody SkillValidation validation) {
        return service.ajouter(validation);
    }

    // Obtenir toutes les validations
    @GetMapping
    public List<SkillValidation> getAll() {
        return service.getAll();
    }

    // Obtenir les validations par submissionId
    @GetMapping("/submission/{id}")
    public List<SkillValidation> getBySubmission(@PathVariable Long id) {
        return service.getBySubmissionId(id);
    }

    // Obtenir les validations par subSkillId
    @GetMapping("/subskill/{id}")
    public List<SkillValidation> getBySubSkill(@PathVariable Long id) {
        return service.getBySubSkillId(id);
    }
}

