package com.xt.hshe.sim.service;

import com.xt.hshe.sim.pojo.entity.SimInfo;
import com.xt.hshe.sim.pojo.entity.Submission;
import com.xt.hshe.sim.repository.SimInfoRepository;
import com.xt.hshe.sim.repository.SubmissionRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

@Service("simService")
public class SimService {

    private static final Logger LOGGER = LogManager.getLogger(SimService.class);

    @Value("${sim.shell.path}")
    private String shFile;


    @Autowired
    private SubmissionRepository submissionRepository;

    @Autowired
    private SimInfoRepository simInfoRepository;


    public void cal(String sid) throws IOException {
        LOGGER.info("Received a sim task[submission #"+sid+" ], begin to find similarity.");
        Long id = Long.valueOf(sid);
        Submission submission = submissionRepository.findOne(id);
        String lang = submission.getLang();
        Long problemId = submission.getProblemId();
        String userId = submission.getUserId();
        List<Submission> otherSub = submissionRepository.findOtherUserSubmission(problemId, userId);
        // 之前的设想是:持久化所有两两相似度数据,这样之后数据比较丰富(重复率分析)
        // 这样用关系型数据库存比较合适,但是又觉得一次性插入的数据太多,是否影响性能?
        // 不过想想没必要搞那么复杂了,只选择保存相似度最大的那一条,也基本可以满足需求:p
        SimInfo theMax = new SimInfo();
        theMax.setProblemId(problemId);
        theMax.setSourceSid(id);
        theMax.setSimilarity(0);
        LOGGER.debug("Found "+otherSub.size()+" submissions this problem.");
        for (Submission s: otherSub) {
            //提交语言不同,直接跳过,不相似
            if (!lang.equals(submission.getLang())) {
                continue;
            }
            int result = callsh(lang, problemId, id, s.getId());
            if (result > theMax.getSimilarity()) {
                theMax.setTargetSid(s.getId());
                theMax.setSimilarity(result);
            }
        }
        simInfoRepository.save(theMax);
    }



    /**
     * 调用sim脚本,脚本输出的值即相似度,无输出代表不相似.
     * @param lang - 语言类型(扩展名)
     * @param pid - 题目id
     * @param sid1 - 第一个提交id
     * @param sid2 - 第二个提交id
     * @return int - 两个提交的相似度百分数(省略百分号)
     */
    private int callsh(String lang, Long pid, Long sid1, Long sid2) throws IOException {
        String command = String.format("%s %s %s %s %s", shFile, lang, pid.toString(), sid1.toString(), sid2.toString());
        LOGGER.debug("Sim Command: "+command);
        Process process = Runtime.getRuntime().exec(command);
        String result;
        try(BufferedReader br = new BufferedReader(new InputStreamReader(process.getInputStream()))) {
            result = br.readLine();
            LOGGER.info("Call result: "+result);
            if (result==null||"".equals(result)) {
                //nothing output
                return 0;
            } else {
                return Integer.parseInt(result);
            }
        }
    }

}
