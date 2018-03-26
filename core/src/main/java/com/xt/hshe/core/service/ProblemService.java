package com.xt.hshe.core.service;

import com.xt.hshe.core.pojo.entity.Problem;
import com.xt.hshe.core.pojo.entity.TestPoint;
import com.xt.hshe.core.pojo.vo.ProblemListItemVo;
import com.xt.hshe.core.pojo.vo.ProblemVo;

import java.util.List;

public interface ProblemService {
    /**
     * 查询所有题目(表格显示对象)
     * @return list-vo
     */
    List<ProblemListItemVo> findAllProblemsVo();

    /**
     * 查询作业内所有题目(表格显示对象)
     * @param topicId - 作业ID
     * @return list-vo
     */
    List<ProblemListItemVo> findProblemsVoInTopic(Long topicId);

    /**
     * 查询作业内所有题目
     * @param topicId - 作业ID
     * @return list
     */
    List<Problem> findProblemsInTopic(Long topicId);

    /**
     * 查询单个题目(表格显示对象)
     * @param problemId - 题目ID
     * @return vo
     */
    ProblemVo findVo(Long problemId);

    /**
     * 查询题目内样例输入输出(第一个测试点)
     * @param problemId - 题目ID
     * @return 测试点对象
     */
    TestPoint findExampleTestPoint(Long problemId);

    /**
     * 查询题目内所有测试点
     * @param problemId - 题目ID
     * @return 测试点对象列表
     */
    List<TestPoint> findTestPoints(Long problemId);

    /**
     * 新增题目
     * @param title - 题目标题
     * @param topicId - 作业ID
     * @param description - 题目描述
     * @param timeLimit - 时间限制
     * @param memoryLimit - 内存限制
     * @param creator - 创建人
     * @return 题目ID
     */
    long addProblem(String title, Long topicId, String description, String timeLimit, String memoryLimit, String creator);

    /**
     * 新增测试点
     * @param indeex - 测试点序号
     * @param input - 输入
     * @param output - 输出
     * @param problemId - 题目ID
     * @return - 测试点ID
     */
    long addTestPoint(int indeex, String input, String output, Long problemId);
}
