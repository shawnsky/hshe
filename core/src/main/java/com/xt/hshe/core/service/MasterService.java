package com.xt.hshe.core.service;

import com.xt.hshe.core.pojo.entity.Problem;
import com.xt.hshe.core.pojo.entity.Student;
import com.xt.hshe.core.pojo.entity.Submission;

import java.util.List;
import java.util.Map;

public interface MasterService {

    /**
     * 查询某提交的最大相似度
     * @param submissionId 提交ID
     * @return SimInfo对象
     */
    int findSim(Long submissionId);


    /**
     * 查询某学生某作业的平均相似度
     * @param userId 用户名
     * @return 平均相似度
     */
    double findAVG(List<Problem> problems, String userId);


    /**
     * 作业完成情况
     * Key "allAC" 得到某作业全部完成学生列表
     * Key "notComplete" 得到未完成的学生列表
     * @param problems - 作业内所有题目
     * @param studentList - 班级内所有学生
     * @return Map
     */
    Map<String, List<Student>> achievement(List<Problem> problems, List<Student> studentList);

    /**
     * 作业相似度分组情况(相似度>=85)
     * @param problem - 题目对象
     * @return - list(list)
     */
    List<List<Submission>> group(Problem problem);


    /**
     * 得到系统统计信息
     * @return count of submissions, topics, problems, students
     */
    Map<String, String> getStatistics();
}
