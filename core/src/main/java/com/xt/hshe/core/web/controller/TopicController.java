package com.xt.hshe.core.web.controller;

import com.xt.hshe.core.pojo.HttpMsg;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TopicController extends BaseController {

    @GetMapping("/t")
    public HttpMsg topic(){
        return new HttpMsg<>(1, null, topicService.findAll());
    }


    @GetMapping("/t/{id}")
    public HttpMsg topicDetail(@PathVariable Long id){
        return new HttpMsg<>(1,null, problemService.findProblemsInTopic(id));
    }
}
