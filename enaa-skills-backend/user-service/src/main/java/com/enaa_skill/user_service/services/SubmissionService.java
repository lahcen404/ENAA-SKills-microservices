package com.enaa_skill.user_service.services;

import com.enaa_skill.user_service.dto.SubmissionRequest;
import com.enaa_skill.user_service.feing.UserInterface;
import com.enaa_skill.user_service.model.Learner;
import com.enaa_skill.user_service.model.Submission;
import com.enaa_skill.user_service.repositories.SubmissionRepositorie;
import com.enaa_skill.user_service.repositories.UserRepositorie;
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


            var userOpt = userRepositorie.findById(submissionRequest.getLearnerId());

            if (userOpt.isEmpty()) {
                throw new IllegalArgumentException("User with ID " + submissionRequest.getLearnerId() + " not found");
            }

            if (!(userOpt.get() instanceof Learner learner)) {
                throw new IllegalArgumentException("User is not a Learner");
            }

            var briefOpt = userInterface.getBriefById(submissionRequest.getBriefId());


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

        public Optional<Submission> findSubmissionById(Long id) {
        return submissionRepositorie.findById(id);
        }
    }
