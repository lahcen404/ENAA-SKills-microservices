package com.enaa_skills.enaa_skills.repository;

import com.enaa_skills.enaa_skills.model.SubSkill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubSkillRepository extends JpaRepository<SubSkill,Long> {
}
