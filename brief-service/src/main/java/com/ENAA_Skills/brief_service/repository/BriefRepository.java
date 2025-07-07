package com.ENAA_Skills.brief_service.repository;

import com.ENAA_Skills.brief_service.model.Brief;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BriefRepository extends JpaRepository<Brief,Long> {
}
