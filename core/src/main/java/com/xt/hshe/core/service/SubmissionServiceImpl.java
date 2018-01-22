package com.xt.hshe.core.service;

import com.xt.hshe.core.pojo.entity.Submission;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by shawn on 2018/1/22.
 */
@Service("submissionService")
public class SubmissionServiceImpl extends BaseService implements SubmissionService {


    @Override
    public List<Submission> findAllSubmissions() {
        return submissionRepository.findAll();
    }

    @Override
    public List<Submission> findSubmissionsInProblem(Long topicId) {
        return submissionRepository.findByProblemId(topicId);
    }

    @Override
    public List<Submission> findSubmissionsOfUser(String userId) {
        return submissionRepository.findByUserId(userId);
    }

    @Override
    public Submission find(Long submissionId) {
        return submissionRepository.findOne(submissionId);
    }
}
