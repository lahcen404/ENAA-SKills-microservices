package com.ENAA_Skill.user_service.dto;

import jakarta.validation.constraints.NotBlank;

import java.time.LocalDateTime;

public class SubmissionRequest {
    @NotBlank(message = "content is required")
    private String content;
    @NotBlank(message = "submittedate is required")
    private LocalDateTime submittedate;
    @NotBlank(message = "learned is required")
    private long learnerId;
    @NotBlank(message = "brief is required")
    private long briefId;

    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }
    public LocalDateTime getSubmittedate() {
        return submittedate;
    }
    public void setSubmittedate(LocalDateTime submittedate) {
        this.submittedate = submittedate;
    }
    public long getLearnerId() {
        return learnerId;
    }
    public void setLearnerId(long learnerId) {
        this.learnerId = learnerId;
    }
    public long getBriefId() {
        return briefId;
    }
    public void setBriefId(long briefId) {
        this.briefId = briefId;
    }
}
