package com.xt.hshe.judge.service;

import com.xt.hshe.judge.mq.Sender;
import com.xt.hshe.judge.pojo.entity.Problem;
import com.xt.hshe.judge.pojo.entity.Submission;
import com.xt.hshe.judge.pojo.entity.TestPoint;
import com.xt.hshe.judge.repository.ProblemRepository;
import com.xt.hshe.judge.repository.SubmissionRepository;
import com.xt.hshe.judge.repository.TestPointRepository;
import com.xt.hshe.judge.util.Consts;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Map;

@Service("judgeService")
public class JudgeService {

    @Autowired
    protected Sender sender;

    @Autowired
    private SubmissionRepository submissionRepository;
    @Autowired
    private TestPointRepository testPointRepository;
    @Autowired
    private ProblemRepository problemRepository;
    @Autowired
    private StringRedisTemplate redisTemplate;

    @Autowired
    private CompileHandler compileHandler;
    @Autowired
    private JudgeHandler judgeHandler;
    @Autowired
    private TestHandler testHandler;

    private static final Logger LOGGER = LogManager.getLogger(JudgeService.class);

    public void judge(Long sid) throws IOException, InterruptedException {
        Submission s = submissionRepository.findOne(sid);
        //查询题目时间内存要求
        Problem p = problemRepository.findOne(s.getProblemId());
        redisTemplate.opsForValue().increment("submitnum:"+p.getId(), 1);
        LOGGER.info("Received a judge task[submission #"+sid+" ], begin to compile.");
        if (compileHandler.compile(s) != 0) {
            submissionRepository.updateJudged(sid, Consts.Judge.CE, 0, 0);
            return;
        }
        //通过编译，可执行文件已生成，抓取测试用例并保存文件
        List<TestPoint> testPoints = testPointRepository.findAllByProblemId(s.getProblemId());
        testHandler.save(s, testPoints);


        
        //运行
        Map<String, Integer> result = judgeHandler.judge(s,p,testPoints);
        submissionRepository.updateJudged(sid, result.get("result"), result.get("usedMemory"), result.get("usedTime"));

        // TODO: 2018/3/8 If result=AC, send ToEval
        if (Consts.Judge.AC == result.get("result")) {
            sender.sendToSim(sid.toString());
            redisTemplate.opsForValue().increment("acceptnum:"+p.getId(), 1);
            redisTemplate.opsForSet().add("acceptuser:"+p.getId(), s.getUserId());
        }
    }
}
