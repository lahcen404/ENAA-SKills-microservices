package com.enaa_skills.brief_service.service;


import com.enaa_skills.brief_service.model.Brief;

import java.util.Optional;

public interface BriefService {
        Brief createBrief(Brief brief);
        Optional<Brief> getBriefById(Long id);
}
