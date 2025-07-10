package com.ENAA_Skill.user_service.services;

import com.ENAA_Skill.user_service.dto.SubmissionRequest;
import com.ENAA_Skill.user_service.model.Learner;
import com.ENAA_Skill.user_service.model.Submission;
import com.ENAA_Skill.user_service.repositories.SubmissionRepositorie;
import com.ENAA_Skill.user_service.repositories.UserRepositorie;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SubmissionService {
    private final SubmissionRepositorie submissionRepositorie;
    private final UserRepositorie userRepositorie;

    public SubmissionService(SubmissionRepositorie submissionRepositorie,UserRepositorie userRepositorie) {
        this.submissionRepositorie = submissionRepositorie;
        this.userRepositorie = userRepositorie;
    }

    public Submission createSubmission(SubmissionRequest submissionRequest) {
        var userOpt = userRepositorie.findById(submissionRequest.getLearnerId());

        if (userOpt.isEmpty()) {
            throw new IllegalArgumentException("User with ID " + submissionRequest.getLearnerId() + " not found");
        }

        if (!(userOpt.get() instanceof Learner learner)) {
            throw new IllegalArgumentException("User is not a Learner");
        }

        Submission submission = new Submission();
        submission.setContent(submissionRequest.getContent());
        submission.setSubmittedate(submissionRequest.getSubmittedate());
        submission.setLearnerId(submission.getLearnerId());
        submission.setBriefId(submissionRequest.getBriefId());

        return submissionRepositorie.save(submission);
    }
}
