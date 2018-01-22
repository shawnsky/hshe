package com.xt.hshe.core.service;

import com.xt.hshe.core.pojo.entity.Problem;
import com.xt.hshe.core.pojo.vo.ProblemListItemVo;
import com.xt.hshe.core.pojo.vo.ProblemVo;

import java.util.List;

public interface ProblemService {
    List<ProblemListItemVo> findAllProblemsVo();
    List<ProblemListItemVo> findProblemsVoInTopic(Long topicId);
    ProblemVo findVo(Long problemId);
}
