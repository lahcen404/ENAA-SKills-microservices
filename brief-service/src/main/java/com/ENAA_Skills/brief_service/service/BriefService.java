package com.ENAA_Skills.brief_service.service;


import com.ENAA_Skills.brief_service.model.Brief;

import java.util.Optional;

public interface BriefService {
        Brief createBrief(Brief brief);
        Optional<Brief> getBriefById(Long id);
}
