package com.xt.hshe.core.service;

import com.xt.hshe.core.pojo.entity.Problem;
import com.xt.hshe.core.pojo.vo.ProblemListItemVo;
import com.xt.hshe.core.pojo.vo.ProblemVo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service("problemService")
public class ProblemServiceImpl extends BaseService implements ProblemService {


    @Override
    public List<ProblemListItemVo> findAllProblemsVo() {
        List<Problem> problems = problemRepository.findAll();
        return entityToVo(problems);
    }

    @Override
    public List<ProblemListItemVo> findProblemsVoInTopic(Long topicId) {
        List<Problem> problems = problemRepository.findByTopicId(topicId);
        return entityToVo(problems);
    }


    private List<ProblemListItemVo> entityToVo(List<Problem> problems){
        List<ProblemListItemVo> vos = new ArrayList<>();
        for (Problem p: problems){
            ProblemListItemVo vo = new ProblemListItemVo();
            vo.setId(p.getId());
            vo.setTitle(p.getTitle());
            vo.setAcceptNum(redisTemplate.opsForValue().get("acceptnum:"+p.getId()));
            vo.setSubmitNum(redisTemplate.opsForValue().get("submitnum:"+p.getId()));
            vos.add(vo);
        }
        return vos;
    }



    @Override
    public ProblemVo findVo(Long problemId) {
        return null;
    }
}
