package com.xt.hshe.core.web.controller;

import com.xt.hshe.core.pojo.HttpMsg;
import com.xt.hshe.core.pojo.entity.Problem;
import com.xt.hshe.core.pojo.entity.Topic;
import com.xt.hshe.core.pojo.vo.ProblemListItemVo;
import com.xt.hshe.core.pojo.vo.ProblemVo;
import com.xt.hshe.core.pojo.vo.TopicVo;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

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
        return new HttpMsg<>(1,null, vo);
    }


    @GetMapping("/p/{id}")
    public HttpMsg problem(@PathVariable Long id, HttpServletRequest request, HttpServletResponse response){
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
        return new HttpMsg<>(1,null, vo);
    }
}
