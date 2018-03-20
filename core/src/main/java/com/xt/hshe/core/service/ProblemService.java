package com.xt.hshe.core.service;

import com.xt.hshe.core.pojo.entity.TestPoint;
import com.xt.hshe.core.pojo.vo.ProblemListItemVo;
import com.xt.hshe.core.pojo.vo.ProblemVo;

import java.util.List;

public interface ProblemService {
    List<ProblemListItemVo> findAllProblemsVo();
    List<ProblemListItemVo> findProblemsVoInTopic(Long topicId);
    ProblemVo findVo(Long problemId);
    TestPoint findExampleTestPoint(Long problemId);
    List<TestPoint> findTestPoints(Long problemId);
    long addProblem(String title, Long topicId, String description, String timeLimit, String memoryLimit, String creator);
    long addTestPoint(int indeex, String input, String output, Long problemId);
}
