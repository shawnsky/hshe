package com.xt.hshe.core.web.controller;

import com.xt.hshe.core.pojo.HttpMsg;
import com.xt.hshe.core.pojo.entity.Classes;
import com.xt.hshe.core.pojo.entity.Student;
import com.xt.hshe.core.util.Consts;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        String topicId = request.getParameter("topic_id");
        Assert.hasText(topicId, "参数缺失!");
        //所选作业的所属班级
        Classes classes = topicService.findClasses(Long.parseLong(topicId));
        //对应班级的所有学生
        List<Student> studentList = classService.findStudents(classes.getId());
        data.put("all", studentList);
        //宏观分析，全部做对多少人，未完成多少人
        List<Student> allAC = new ArrayList<>();
        List<Student> notComplete = new ArrayList<>();


        //分组情况分析


        //详细报告，每道题具体情况，显示所有提交信息及重复率


        return new HttpMsg<>(Consts.ServerCode.SUCCESS, null, data);
    }
}
