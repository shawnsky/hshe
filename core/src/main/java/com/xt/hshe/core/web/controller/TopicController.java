package com.xt.hshe.core.web.controller;

import com.xt.hshe.core.pojo.HttpMsg;
import com.xt.hshe.core.pojo.entity.Topic;
import com.xt.hshe.core.pojo.vo.TopicVo;
import com.xt.hshe.core.util.Consts;
import org.apache.http.util.Asserts;
import org.springframework.http.HttpStatus;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

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

    @PostMapping("/t")
    public HttpMsg<Long> TaddTopic(HttpServletRequest request, HttpServletResponse response, @RequestBody Map map) {
        String title = (String) map.get("title");
        Assert.hasText(title, "作业标题不能为空!");
        String classFlag = (String) map.get("class_flag");
        Assert.hasText(classFlag, "班级编号不能为空!");
        String classId = classFlag.substring(0, classFlag.indexOf('-'));
        String creator = (String) request.getAttribute("user_id");
        String begin = (String) map.get("begin_time");
        String end = (String) map.get("end_time");
        Date dateBegin;
        Date dateEnd;
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        if (begin==null || "".equals(begin)){
            dateBegin = new Date();
        } else {
            try {
                dateBegin = df.parse(begin);
            } catch (ParseException e) {
                dateBegin = new Date();
            }
        }
        try {
            if (end==null || "".equals(end)){
                dateEnd = df.parse("9999-01-01");
            } else {
                dateEnd = df.parse(end);
            }
        } catch (ParseException e) {
            dateEnd = new Date();
        }
        //returns topic id.
        Long id = topicService.add(Long.parseLong(classId), title, null, String.valueOf(dateBegin.getTime()), String.valueOf(dateEnd.getTime()), creator);
        return new HttpMsg<>(Consts.ServerCode.SUCCESS, null, id);
    }
}
