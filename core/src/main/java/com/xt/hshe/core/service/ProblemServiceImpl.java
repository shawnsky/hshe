package com.xt.hshe.core.service;

import com.xt.hshe.core.pojo.entity.Problem;
import com.xt.hshe.core.pojo.entity.TestPoint;
import com.xt.hshe.core.pojo.entity.TopicProblem;
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

    @Override
    public List<Problem> findProblemsInTopic(Long topicId) {
        return problemRepository.findByTopicId(topicId);
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
        Problem p = problemRepository.findOne(problemId);
        if (p == null) {
            return null;
        }
        Long pid = p.getId();
        ProblemVo vo = new ProblemVo();
        vo.setId(pid);
        vo.setTitle(p.getTitle());
        vo.setDescription(p.getDescription());
        vo.setMemoryLimit(p.getMemoryLimit());
        vo.setTimeLimit(p.getTimeLimit());
        vo.setCreateTime(p.getCreateTime());
        vo.setAcceptNum(redisTemplate.opsForValue().get("acceptnum:"+pid));
        vo.setSubmitNum(redisTemplate.opsForValue().get("submitnum:"+pid));
        vo.setViewerNum(redisTemplate.opsForValue().get("viewernum:"+pid));
        String creatorNick = authService.findNick(false, p.getCreator());
        if (creatorNick == null||"".equals(creatorNick)){
            vo.setCreator(p.getCreator());
        } else {
            vo.setCreator(creatorNick);
        }
        TestPoint testPointExample = findExampleTestPoint(pid);
        vo.setInputExample(testPointExample.getInput());
        vo.setOutputExample(testPointExample.getOutput());
        return vo;
    }

    @Override
    public TestPoint findExampleTestPoint(Long problemId) {
        return testPointRepository.findExample(problemId);
    }

    @Override
    public List<TestPoint> findTestPoints(Long problemId) {
        return testPointRepository.findAllByProblemId(problemId);
    }

    @Override
    public long addProblem(String title, Long topicId, String description, String timeLimit, String memoryLimit, String creator) {
        Problem problem = new Problem();
        problem.setTitle(title);
        problem.setCreateTime(String.valueOf(System.currentTimeMillis()));
        problem.setCreator(creator);
        problem.setDescription(description);
        problem.setMemoryLimit(memoryLimit);
        problem.setTimeLimit(timeLimit);
        problemRepository.save(problem);
        Long problemId = problem.getId();
        TopicProblem tp = new TopicProblem();
        tp.setTopicId(topicId);
        tp.setProblemId(problemId);
        topicProblemRepository.save(tp);
        return problemId;
    }

    @Override
    public long addTestPoint(int indeex, String input, String output, Long problemId) {
        TestPoint tp = new TestPoint();
        tp.setIndeex(indeex);
        tp.setInput(input);
        tp.setOutput(output);
        tp.setProblemId(problemId);
        testPointRepository.save(tp);
        return tp.getId();
    }


}
