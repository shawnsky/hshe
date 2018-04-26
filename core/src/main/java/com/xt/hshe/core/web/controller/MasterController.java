package com.xt.hshe.core.web.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.xt.hshe.core.annotation.TeacherRequired;
import com.xt.hshe.core.pojo.HttpMsg;
import com.xt.hshe.core.pojo.entity.*;
import com.xt.hshe.core.pojo.vo.SubmissionMasterVo;
import com.xt.hshe.core.util.Consts;
import com.xt.hshe.core.util.SimComparator;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.*;

@RestController
@RequestMapping("/api")
public class MasterController extends BaseController {
    @GetMapping("/statistics")
    @TeacherRequired
    public HttpMsg<Map<String, String>> Tstatistics(HttpServletRequest request, HttpServletResponse response){
        return new HttpMsg<>(Consts.ServerCode.SUCCESS, null, masterService.getStatistics());
    }

    @GetMapping("/analysis")
    @TeacherRequired
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

        data.put("allStudents", studentList);


        //全部做对多少人，未完成多少人
        Map<String, List<Student>> r = masterService.achievement(problems, studentList);
        List<Student> allACList = r.get("allAC");
        List<Student> notComplete = r.get("notComplete");
        data.put("allACWithAVG", avgWrap(problems, allACList));
        data.put("notCompleteWithAVG", avgWrap(problems, notComplete));

        //分组情况分析
        //详细报告，每道题具体情况，显示所有提交信息及重复率
        List<Map<String, Object>> detailInfos = new ArrayList<>();
        for (Problem p: problems) {
            Map<String, Object> map = new HashMap<>();
            map.put("problem_id", p.getId());
            map.put("problem_title", p.getTitle());
            List<Submission> list = submissionService.findSubmissionsInProblem(p.getId());
            List<SubmissionMasterVo> voList = new ArrayList<>();
            for (Submission s: list) {
                SubmissionMasterVo vo = new SubmissionMasterVo();
                BeanUtils.copyProperties(s, vo);
                int sim = masterService.findSim(s.getId());
                //-1表示没有相似度信息，可能系统异常或者还没计算完毕
                vo.setSim(sim);
                voList.add(vo);
            }
            map.put("submissions", voList);
            List<List<Submission>> subGroups = masterService.group(p);
            map.put("groups", subGroups);
            detailInfos.add(map);
        }
        data.put("detailInfos", detailInfos);
        return new HttpMsg<>(Consts.ServerCode.SUCCESS, null, data);
    }

    // FIXME: 2018/4/26 获取118.25.0.112机器上的容器信息.又不是不能用.之后可以删了
    @GetMapping("/status")
    @TeacherRequired
    public String status(HttpServletRequest request, HttpServletResponse response) throws URISyntaxException, IOException {
        //Request for JWT
        RestTemplate authTemplate = new RestTemplate();
        URI authURI = new URI("http://118.25.0.112:9008/api/auth");
        HttpEntity<EntitySubject> authEntity = new HttpEntity<>(new EntitySubject());
        ResponseEntity<String> authResponseEntity = authTemplate.postForEntity(authURI, authEntity, String.class);
        String body = authResponseEntity.getBody();
        String jwt = body.substring(body.indexOf(":")+2, body.indexOf("}")-1);

        //Request Containers Info
        RestTemplate template = new RestTemplate();
        URI infoURI = URI.create("http://118.25.0.112:9008/api/endpoints/1/docker/containers/json");
        HttpHeaders requestHeaders = new HttpHeaders();
        requestHeaders.add("Authorization", jwt);
        HttpEntity<String> infoEntity = new HttpEntity<>(null, requestHeaders);
        ResponseEntity<String> entityContainerResponseEntity = template.exchange(infoURI, HttpMethod.GET, infoEntity, String.class);
        return entityContainerResponseEntity.getBody();
    }

    private List<StudentMasterVo> avgWrap(List<Problem> problems, List<Student> students) {
        List<StudentMasterVo> vos = new ArrayList<>();
        for (Student s: students) {
            StudentMasterVo vo = new StudentMasterVo();
            BeanUtils.copyProperties(s, vo);
            vo.setSimAVG(masterService.findAVG(problems, s.getId()));
            vos.add(vo);
        }
        return vos;
    }

    private class EntitySubject {
        String Username = "admin";
        String Password = "cxt960323";
        public String getUsername() {
            return Username;
        }

        public void setUsername(String username) {
            Username = username;
        }

        public String getPassword() {
            return Password;
        }

        public void setPassword(String password) {
            Password = password;
        }
    }



    private class EntityContainers {
        List<Container> list;
        class Container {
            String Command;
            Long Created;
            Object HostConfig;
            String Id;
            String Image;
            String ImageID;
            Object Labels;
            List<Object> Mounts;
            List<String> Names;
            Object NetworkSettings;
            Object Ports;
            String State;
            String Status;
        }
    }
}
