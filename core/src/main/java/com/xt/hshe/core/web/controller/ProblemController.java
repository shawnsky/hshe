package com.xt.hshe.core.web.controller;

import com.xt.hshe.core.pojo.HttpMsg;
import com.xt.hshe.core.pojo.entity.Problem;
import com.xt.hshe.core.pojo.entity.Topic;
import com.xt.hshe.core.pojo.vo.ProblemListItemVo;
import com.xt.hshe.core.pojo.vo.TopicVo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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


//    @GetMapping("/p/{id}")
//    public HttpMsg problem(@PathVariable Long id){
//        Problem problem = problemService.find(id);
//        if (problem==null){
//            return new HttpMsg(0,"不存在的~");
//        }
//        return new HttpMsg<>(1,null, problem);
//    }
}
