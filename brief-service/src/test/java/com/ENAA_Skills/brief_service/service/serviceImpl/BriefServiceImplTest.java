package com.ENAA_Skills.brief_service.service.serviceImpl;

import com.ENAA_Skills.brief_service.dto.SkillDTO;
import com.ENAA_Skills.brief_service.model.Brief;
import com.ENAA_Skills.brief_service.service.BriefService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@AutoConfigureTestDatabase
class BriefServiceImplTest {

    @Autowired
    private BriefService briefService;


    @Test
    void createBrief() {

        Long id = 1L;
        String title = "Brief 1";
        List<Long> skills = List.of(1L,14L);


        Brief brief = new Brief();

        brief.setId(id);
        brief.setTitle(title);
        brief.setSkillIds(skills);

        Brief createdBrief = briefService.createBrief(brief);

        assertNotNull(createdBrief.getId());
        assertEquals(id, createdBrief.getId());
        assertEquals(title, createdBrief.getTitle());
        assertEquals(skills, createdBrief.getSkillIds());
    }

}