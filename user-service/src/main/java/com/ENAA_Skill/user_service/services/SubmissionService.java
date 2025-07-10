package com.ENAA_Skill.user_service.services;

import com.ENAA_Skill.user_service.dto.SubmissionRequest;
import com.ENAA_Skill.user_service.feing.UserInterface;
import com.ENAA_Skill.user_service.model.Learner;
import com.ENAA_Skill.user_service.model.Submission;
import com.ENAA_Skill.user_service.repositories.SubmissionRepositorie;
import com.ENAA_Skill.user_service.repositories.UserRepositorie;
import com.ENAA_Skills.brief_service.model.Brief;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SubmissionService {
    private final SubmissionRepositorie submissionRepositorie;
    private final UserRepositorie userRepositorie;
    private final UserInterface userInterface;

    public SubmissionService(SubmissionRepositorie submissionRepositorie,
                             UserRepositorie userRepositorie,
                             UserInterface userInterface) {
        this.submissionRepositorie = submissionRepositorie;
        this.userRepositorie = userRepositorie;
        this.userInterface = userInterface;
    }

    public Submission createSubmission(SubmissionRequest submissionRequest) {
            System.out.println("==> learnerId = " + submissionRequest.getLearnerId());
            System.out.println("==> briefId = " + submissionRequest.getBriefId());
            System.out.println("==> submittedate = " + submissionRequest.getSubmittedate());

            var userOpt = userRepositorie.findById(submissionRequest.getLearnerId());

            if (userOpt.isEmpty()) {
                throw new IllegalArgumentException("User with ID " + submissionRequest.getLearnerId() + " not found");
            }

            if (!(userOpt.get() instanceof Learner learner)) {
                throw new IllegalArgumentException("User is not a Learner");
            }

            var briefOpt = userInterface.getBriefById(submissionRequest.getBriefId());
            System.out.println("==> brief found = " + briefOpt.isPresent());

            if (briefOpt.isEmpty()) {
                throw new IllegalArgumentException("Brief not found");
            }

            Submission submission = new Submission();
            submission.setContent(submissionRequest.getContent());
            submission.setSubmittedate(submissionRequest.getSubmittedate());
            submission.setLearnerId(learner);
            submission.setBriefId(submissionRequest.getBriefId());

            return submissionRepositorie.save(submission);
        }
    }
