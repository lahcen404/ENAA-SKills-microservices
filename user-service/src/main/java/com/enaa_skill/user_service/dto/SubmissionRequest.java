package com.enaa_skill.user_service.dto;

import java.time.LocalDateTime;
public class SubmissionRequest {
    private String content;
    private LocalDateTime submittedate; // changer ici en LocalDateTime
    private Long learnerId;
    private Long briefId;

    // Getters & Setters
    public String getContent() { return content; }
    public void setContent(String content) { this.content = content; }

    public LocalDateTime getSubmittedate() { return submittedate; }
    public void setSubmittedate(LocalDateTime submittedate) { this.submittedate = submittedate; }

    public Long getLearnerId() { return learnerId; }
    public void setLearnerId(Long learnerId) { this.learnerId = learnerId; }

    public Long getBriefId() { return briefId; }
    public void setBriefId(Long briefId) { this.briefId = briefId; }
}
