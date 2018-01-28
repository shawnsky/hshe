package com.xt.hshe.core.web.controller;

import com.xt.hshe.core.pojo.HttpMsg;
import com.xt.hshe.core.pojo.entity.Topic;
import com.xt.hshe.core.pojo.vo.TopicListItemVo;
import com.xt.hshe.core.pojo.vo.TopicVo;
import com.xt.hshe.core.util.Consts;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class TopicController extends BaseController {

    @GetMapping("/t")
    public HttpMsg topicList(){
        return new HttpMsg<>(Consts.ServerCode.SUCCESS, null, topicService.findAllTopicsVo());
    }


    @GetMapping("/t/{id}")
    public HttpMsg topic(@PathVariable Long id, HttpServletResponse response){
        TopicVo vo = topicService.findVo(id);
        if (vo==null){
            response.setStatus(HttpStatus.NOT_FOUND.value());
            return new HttpMsg<>(Consts.ServerCode.FAILURE, "不存在的~");
        }
        return new HttpMsg<>(Consts.ServerCode.SUCCESS, null, vo);
    }
}
