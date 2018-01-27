package com.xt.hshe.core.web.controller;

import com.xt.hshe.core.pojo.HttpMsg;
import com.xt.hshe.core.pojo.entity.Problem;
import com.xt.hshe.core.pojo.entity.Submission;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class SubmissionController extends BaseController{
    @GetMapping("/s")
    public HttpMsg submissions(){
        return new HttpMsg<>(1,null, submissionService.findAllSubmissions());
    }
    @GetMapping("/s/{id}")
    public HttpMsg submission(@PathVariable Long id){
        Submission submission = submissionService.find(id);
        if (submission==null){
            return new HttpMsg(0,"不存在的~");
        }
        return new HttpMsg<>(1,null, submission);
    }
}
