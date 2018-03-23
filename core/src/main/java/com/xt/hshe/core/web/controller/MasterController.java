package com.xt.hshe.core.web.controller;

import com.xt.hshe.core.pojo.HttpMsg;
import com.xt.hshe.core.pojo.entity.Classes;
import com.xt.hshe.core.pojo.entity.Problem;
import com.xt.hshe.core.pojo.entity.Student;
import com.xt.hshe.core.pojo.entity.Submission;
import com.xt.hshe.core.util.Consts;
import com.xt.hshe.core.util.SimComparator;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;

@RestController
@RequestMapping("/api")
public class MasterController extends BaseController {
    @GetMapping("/statistics")
    public HttpMsg Tstatistics(HttpServletRequest request, HttpServletResponse response){
        Map<String, String> data = new HashMap<>();
        return null;
    }

    @GetMapping("/analysis")
    public HttpMsg<Map<String, Object>> Tanalysis(HttpServletRequest request, HttpServletResponse response) {
        Map<String, Object> data = new HashMap<>();
        String Id = request.getParameter("topic_id");
        Assert.hasText(Id, "参数缺失!");
        Long topicId = Long.parseLong(Id);
        //所选作业的所有题目
        List<Problem> problems = problemService.findProblemsInTopic(topicId);
        if (problems==null||problems.size()==0){
            return new HttpMsg<>(Consts.ServerCode.FAILURE, "这个作业没有题目", null);
        }
        //所选作业的所属班级
        Classes classes = topicService.findClasses(topicId);
        if (classes==null) {
            return new HttpMsg<>(Consts.ServerCode.FAILURE, "这个作业不属于任何班级", null);
        }
        //对应班级的所有学生
        List<Student> studentList = classService.findStudents(classes.getId());
        if (studentList==null||studentList.size()==0) {
            return new HttpMsg<>(Consts.ServerCode.FAILURE, "班级内没有学生", null);
        }
        data.put("all", studentList);


        //全部做对多少人，未完成多少人
        Map<String, List<Student>> r = masterService.achievement(problems, studentList);
        data.put("allAC", r.get("allAC"));
        data.put("notComplete", r.get("notComplete"));

        //分组情况分析，最大连通分量
        //Submission分组
        List<Map<String, Object>> groupInfos = new ArrayList<>();
        for (Problem p: problems) {
            Map<String, Object> map = new HashMap<>();
            map.put("problem_id", p.getId());
            map.put("problem_title", p.getTitle());
            List<List<Submission>> subGroups = masterService.group(p);
            map.put("groups", subGroups);
            groupInfos.add(map);
        }
        data.put("groupInfos", groupInfos);


        //详细报告，每道题具体情况，显示所有提交信息及重复率



        return new HttpMsg<>(Consts.ServerCode.SUCCESS, null, data);
    }
}
