package com.ENAA_Skill.user_service.repositories;

import com.ENAA_Skill.user_service.model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.support.Repositories;

public interface AdminRepositorie extends JpaRepository<Admin, Integer> {
}
