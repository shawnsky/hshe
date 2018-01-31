package com.xt.hshe.judge.service;

import com.xt.hshe.judge.pojo.entity.Submission;
import com.xt.hshe.judge.pojo.entity.TestPoint;
import com.xt.hshe.judge.repository.SubmissionRepository;
import com.xt.hshe.judge.repository.TestPointRepository;
import com.xt.hshe.judge.util.Consts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service("judgeService")
public class JudgeService {
    @Autowired
    private SubmissionRepository submissionRepository;
    @Autowired
    private TestPointRepository testPointRepository;

    @Autowired
    private CompileHandler compileHandler;
    @Autowired
    private JudgeHandler judgeHandler;

    public void judge(Long sid) throws IOException, InterruptedException {
        Submission s = submissionRepository.findOne(sid);
        if (compileHandler.compile(s) != 0) {
            submissionRepository.updateJudged(sid, Consts.Judge.CE);
            return;
        }
        //通过编译，可执行文件已生成
        List<TestPoint> testPoints = testPointRepository.findAllByProblemId(s.getProblemId());

        if (judgeHandler.judge(s, testPoints) != 0) {
            submissionRepository.updateJudged(sid, Consts.Judge.WA);
        } else {
            submissionRepository.updateJudged(sid, Consts.Judge.AC);
        }
    }
}
