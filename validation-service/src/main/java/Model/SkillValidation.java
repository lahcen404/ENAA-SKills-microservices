package Model;

import Model.ValidationStatus;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SkillValidation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long submissionId; // ID du rendu
    private Long subSkillId;   // ID de la sous-compétence

    @Enumerated(EnumType.STRING)
    private ValidationStatus status;
}
