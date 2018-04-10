package com.xt.hshe.core.web.controller;

import com.xt.hshe.core.annotation.TeacherRequired;
import com.xt.hshe.core.pojo.HttpMsg;
import com.xt.hshe.core.pojo.entity.Problem;
import com.xt.hshe.core.pojo.entity.Topic;
import com.xt.hshe.core.pojo.vo.ProblemListItemVo;
import com.xt.hshe.core.pojo.vo.ProblemVo;
import com.xt.hshe.core.pojo.vo.TopicVo;
import com.xt.hshe.core.util.Consts;
import org.springframework.http.HttpStatus;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class ProblemController extends BaseController{
    @GetMapping("/p")
    public HttpMsg problems(){
        List<ProblemListItemVo> problemListItemVos = problemService.findAllProblemsVo();
        TopicVo vo = new TopicVo();
        vo.setId(67373);
        vo.setTitle("所有题目");
        vo.setProblemListItemVos(problemListItemVos);
        return new HttpMsg<>(Consts.ServerCode.SUCCESS,null, vo);
    }


    @GetMapping("/p/{id}")
    public HttpMsg problem(@PathVariable Long id, HttpServletRequest request, HttpServletResponse response){
        redisTemplate.opsForValue().increment("viewernum:"+id,1);
        ProblemVo vo = problemService.findVo(id);
        if (vo==null){
            response.setStatus(HttpStatus.NOT_FOUND.value());
            return new HttpMsg(0,"不存在的~");
        }
        String referrer = request.getHeader("My-Referer");
        int i = referrer.indexOf("/topic/");
        if (referrer.endsWith("/problem")){
            vo.setReferer("所有题目");
        } else if (i != -1){
            Long tid = Long.parseLong(referrer.substring(i+7));
            vo.setReferer(topicService.findTopicTitle(tid));
        } else {
            vo.setReferer(null);
        }
        return new HttpMsg<>(Consts.ServerCode.SUCCESS,null, vo);
    }

    @PostMapping("/p")
    @TeacherRequired
    public HttpMsg<String> Tadd(HttpServletRequest request, HttpServletResponse response, @RequestBody Map map){
        String title = (String) map.get("title");
        Assert.hasText(title, "题目标题不能为空!");
        String topicFlag = (String) map.get("topic_flag");
        Assert.hasText(topicFlag, "作业编号不能为空!");
        String topicId = topicFlag.substring(0, topicFlag.indexOf('-'));
        String description = (String) map.get("description");
        Assert.hasText(description, "题目描述不能为空!");
        String timeLimit = String.valueOf((Integer) map.get("time_limit"));
        Assert.hasText(timeLimit, "时间限制不能为空!");
        String memoryLimit = String.valueOf(map.get("memory_limit"));
        Assert.hasText(memoryLimit, "内存限制不能为空!");
        String testsCount = String.valueOf(map.get("tests_count"));
        Assert.hasText(testsCount, "测试用例缺失!");
        String creator = (String) request.getAttribute("user_id");
        long problemId = problemService.addProblem(title, Long.parseLong(topicId), description, timeLimit, memoryLimit, creator);
        int n = Integer.parseInt(testsCount);
        for (int i=0;i<n;i++){
            String input = (String) map.get("input"+i);
            String output = (String) map.get("output"+i);
            long testPointId = problemService.addTestPoint(i, input, output, problemId);
        }
        return new HttpMsg<>(Consts.ServerCode.SUCCESS, null,"题目上传成功");
    }
}
