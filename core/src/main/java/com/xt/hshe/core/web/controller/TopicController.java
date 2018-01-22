package com.xt.hshe.core.web.controller;

import com.xt.hshe.core.pojo.HttpMsg;
import com.xt.hshe.core.pojo.entity.Topic;
import com.xt.hshe.core.pojo.vo.TopicListItemVo;
import com.xt.hshe.core.util.Consts;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class TopicController extends BaseController {

    @GetMapping("/t")
    public HttpMsg topicList(){
        return new HttpMsg<>(Consts.ServerCode.SUCCESS, null, topicService.findAllTopicsVo());
    }


    @GetMapping("/t/{id}")
    public HttpMsg topic(@PathVariable Long id){
        return new HttpMsg<>(Consts.ServerCode.SUCCESS, null, topicService.findVo(id));
    }
}
