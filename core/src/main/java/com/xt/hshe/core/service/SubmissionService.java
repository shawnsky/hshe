package com.xt.hshe.core.service;

import com.xt.hshe.core.pojo.entity.Problem;
import com.xt.hshe.core.pojo.entity.Submission;
import com.xt.hshe.core.pojo.entity.Topic;

import java.util.List;

public interface SubmissionService {
    List<Submission> findAllSubmissions();
    List<Submission> findSubmissionsInProblem(Long topicId);
    List<Submission> findSubmissionsOfUser(String userId);
    Submission find(Long submissionId);
}
