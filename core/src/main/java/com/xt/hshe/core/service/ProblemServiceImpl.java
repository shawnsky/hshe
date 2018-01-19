package com.xt.hshe.core.service;

import com.xt.hshe.core.pojo.entity.Problem;
import org.springframework.stereotype.Service;

import java.util.List;
@Service("problemService")
public class ProblemServiceImpl extends BaseService implements ProblemService {

    @Override
    public List<Problem> findAllProblems() {
        return problemRepository.findAll();
    }

    @Override
    public List<Problem> findProblemsInTopic(Long topicId) {
        return problemRepository.findByTopicId(topicId);
    }

    @Override
    public Problem find(Long problemId) {
        return problemRepository.findOne(problemId);
    }


}
