package com.xt.hshe.core.service;

import com.xt.hshe.core.pojo.entity.Submission;
import com.xt.hshe.core.pojo.entity.Topic;
import com.xt.hshe.core.pojo.entity.TopicProblem;
import com.xt.hshe.core.util.Consts;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.Date;
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
    public List<Submission> findSubmissionsInProblem(Long problemId) {
        return submissionRepository.findByProblemId(problemId);
    }

    @Override
    public List<Submission> findSubmissionsOfUser(String userId) {
        return submissionRepository.findByUserId(userId);
    }

    @Override
    public Submission find(Long submissionId) {
        return submissionRepository.findOne(submissionId);
    }

    @Override
    public Long submit(String uid, String pid, String lang, String src) {
        Submission s = new Submission();
        s.setUserId(uid);
        s.setProblemId(Long.parseLong(pid));
        s.setLang(lang);
        s.setSrc(src);
        s.setLength(src.getBytes().length);
        s.setCreateTime(String.valueOf(System.currentTimeMillis()));
        s.setJudged(-1);
        submissionRepository.save(s);
        return s.getId();
    }

    @Override
    public Long countOfSubmit(String userId) {
        return submissionRepository.countByUserId(userId);
    }

    @Override
    public Long countOfAccept(String userId) {
        return submissionRepository.countByUserIdAndJudged(userId, Consts.Judge.AC);
    }

    @Override
    public boolean isSubmittable(Long problemId) {
        List<TopicProblem> tps = topicProblemRepository.findByProblemId(problemId);
        if (tps == null || tps.size()!=1) {
            return false;
        }
        Topic topic = topicRepository.findOne(tps.get(0).getTopicId());
        long start = Long.parseLong(topic.getStartTime());
        long end = Long.parseLong(topic.getEndTime());
        long current = System.currentTimeMillis();
        return start < current && current < end;
    }
}
