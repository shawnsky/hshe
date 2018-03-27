package com.xt.hshe.core.service;

import com.xt.hshe.core.pojo.entity.Problem;
import com.xt.hshe.core.pojo.entity.Submission;
import com.xt.hshe.core.pojo.entity.Topic;

import java.util.List;

public interface SubmissionService {
    /**
     * 查询所有提交记录
     * @return list
     */
    List<Submission> findAllSubmissions();

    /**
     * 查询某题目所有提交记录
     * @param problemId - 题目ID
     * @return list
     */
    List<Submission> findSubmissionsInProblem(Long problemId);


    /**
     * 查询某用户所有提交记录
     * @param userId - 用户名
     * @return list
     */
    List<Submission> findSubmissionsOfUser(String userId);


    /**
     * 查询提交对象
     * @param submissionId - 提交记录ID
     * @return submission
     */
    Submission find(Long submissionId);

    /**
     * 提交
     * @param uid 用户名
     * @param pid 题目ID
     * @param lang 语言
     * @param src 源代码
     * @return 提交记录ID
     */
    Long submit(String uid, String pid, String lang, String src);

    /**
     * 查询某用户提交记录数
     * @param userId 用户名
     * @return 记录数
     */
    Long countOfSubmit(String userId);

    /**
     * 查询某用户AC记录数
     * @param userId 用户名
     * @return 记录数
     */
    Long countOfAccept(String userId);


    /**
     * 计算当前提交是否符合题目日期限制
     * @param problemId 题目ID
     * @return 是否可提交
     */
    boolean isSubmittable(Long problemId);
}
