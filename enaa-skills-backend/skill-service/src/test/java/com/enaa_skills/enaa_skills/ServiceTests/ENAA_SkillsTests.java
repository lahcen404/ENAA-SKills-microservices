package com.enaa_skills.enaa_skills.ServiceTests;

import com.enaa_skills.enaa_skills.dto.SkillDTO;
import com.enaa_skills.enaa_skills.dto.SubSkillDTO;
import com.enaa_skills.enaa_skills.model.Skill;
import com.enaa_skills.enaa_skills.model.SubSkill;
import com.enaa_skills.enaa_skills.model.ValidationStatus;
import com.enaa_skills.enaa_skills.repository.SkillRepository;
import com.enaa_skills.enaa_skills.repository.SubSkillRepository;
import com.enaa_skills.enaa_skills.service.SkillManagementService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@AutoConfigureTestDatabase
@Transactional
public class ENAA_SkillsTests {

    private final SkillManagementService skillManagementService;
    private final SkillRepository skillRepository;
    private final SubSkillRepository subSkillRepository;

    private Skill existingSkill;

    @Autowired
    public ENAA_SkillsTests(SkillManagementService skillManagementService, SkillRepository skillRepository, SubSkillRepository subSkillRepository) {
        this.skillManagementService = skillManagementService;
        this.skillRepository = skillRepository;
        this.subSkillRepository = subSkillRepository;
    }

    @BeforeEach
    void setUp() {
        //clear all
        skillRepository.deleteAll();

        Skill skill = new Skill();
        skill.setName("OOP");

        List<SubSkill> subSkills = new ArrayList<>();
        subSkills.add(new SubSkill("Heritage", "Abstraction", ValidationStatus.NOT_VALIDATE));
        subSkills.add(new SubSkill("SubSkill1", "SubSkill2", ValidationStatus.NOT_VALIDATE));
        subSkills.add(new SubSkill("Subskill test 1", "Subskill test 2", ValidationStatus.VALIDATE));

        for (SubSkill subSkill : subSkills) {
            subSkill.setSkill(skill);
        }
        skill.setSubSkills(subSkills);

        existingSkill = skillRepository.save(skill);
    }

    @Test
    void createSkillTest() {
        SubSkillDTO newSubSkill = new SubSkillDTO(null, "Springboot", "test", ValidationStatus.NOT_VALIDATE);
        SkillDTO newSkill = new SkillDTO(null, "SpringFramework", false, List.of(newSubSkill));

        SkillDTO skillCreated = skillManagementService.createSkill(newSkill);

        assertNotNull(skillCreated);
        assertNotNull(skillCreated.getId());
        assertEquals("SpringFramework", skillCreated.getName());
        assertEquals(1, skillCreated.getSubSkills().size());
        assertEquals("Springboot", skillCreated.getSubSkills().get(0).getName());
        assertEquals(ValidationStatus.NOT_VALIDATE, skillCreated.getSubSkills().get(0).getStatus());
    }

    @Test
    void getAllSkillsTest(){

        List<SkillDTO> allSkills = skillManagementService.getAllSkills();

        assertNotNull(allSkills);
        assertEquals(1,allSkills.size());

    }

    @Test
    void deleteSkillTest(){
        Long skillId = existingSkill.getId();
        skillManagementService.deleteSkill(skillId);

        assertFalse(skillRepository.existsById(skillId));
    }


    @Test
    void updateSkill(){
        Long skillId = existingSkill.getId();
        Long subSkillIdToUpdate = existingSkill.getSubSkills().get(0).getId();

        SubSkillDTO updatedSubSkillDTO = new SubSkillDTO(subSkillIdToUpdate, "update name subskill", "new descriprion subskill", ValidationStatus.VALIDATE);

        SkillDTO skillUpdate = new SkillDTO(skillId, "update Java ", false, List.of(updatedSubSkillDTO));

        SkillDTO updatedSkillDTO = skillManagementService.updateSkill(skillId, skillUpdate);

        assertNotNull(updatedSkillDTO);
        assertEquals("update Java ", updatedSkillDTO.getName());

        SubSkill updatedSubSkillFromDb = subSkillRepository.findById(subSkillIdToUpdate).orElseThrow();
        assertEquals("update name subskill", updatedSubSkillFromDb.getName());
        assertEquals(ValidationStatus.VALIDATE, updatedSubSkillFromDb.getStatus());
        assertEquals("new descriprion subskill", updatedSubSkillFromDb.getDescription());

    }
}