package com.xt.hshe.core.service;

import com.xt.hshe.core.pojo.entity.Problem;

import java.util.List;

public interface ProblemService {
    List<Problem> findAllProblems();
    List<Problem> findProblemsInTopic(Long topicId);
    Problem find(Long problemId);
}
