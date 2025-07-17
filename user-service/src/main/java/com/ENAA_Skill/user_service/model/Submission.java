package com.ENAA_Skill.user_service.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Submission {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String content;
    private LocalDateTime submittedate;
    private long briefId;

    public Learner getLearnerId() {
        return learnerId;
    }

    public void setLearnerId(Learner learnerId) {
        this.learnerId = learnerId;
    }

    @ManyToOne
    @JoinColumn(name = "learner_id")
    @JsonIgnoreProperties("submissions")
    private Learner learnerId;



    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

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



    public long getBriefId() {
        return briefId;
    }
    public void setBriefId(long briefId) {
        this.briefId = briefId;
    }
}
