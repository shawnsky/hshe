package com.xt.hshe.core.web.controller;

import com.xt.hshe.core.pojo.HttpMsg;
import com.xt.hshe.core.pojo.entity.Problem;
import com.xt.hshe.core.pojo.entity.Submission;
import com.xt.hshe.core.util.Consts;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class SubmissionController extends BaseController{
    @GetMapping("/s")
    public HttpMsg submissions(){
        return new HttpMsg<>(Consts.ServerCode.SUCCESS,null, submissionService.findAllSubmissions());
    }


    @GetMapping("/s/{id}")
    public HttpMsg submission(@PathVariable Long id){
        Submission submission = submissionService.find(id);
        if (submission==null){
            return new HttpMsg(Consts.ServerCode.FAILURE,"不存在的~");
        }
        return new HttpMsg<>(Consts.ServerCode.SUCCESS,null, submission);
    }

    @PostMapping("/s")
    public HttpMsg submit(HttpServletRequest request, HttpServletResponse response, @RequestBody Map map){
        String uid = (String) map.get("userId");
        Assert.hasText(uid, "请求失败，请重新登录!");
        Integer l = (Integer) map.get("problemId");
        String pid = l.toString();
        Assert.hasText(pid, "请求失败，请重试!");
        String src = (String) map.get("src");
        Assert.hasText(src, "代码不能为空!");
        String lang = (String) map.get("lang");
        Assert.hasText(lang, "请选择编程语言!");
        Long sid = submissionService.submit(uid, pid, lang, src);//储存Submission到数据库
        if (sid==null) {
            return new HttpMsg(Consts.ServerCode.FAILURE, "提交失败");
        } else {
            sender.sendToJudge(sid.toString());//发消息给q执行编译判题
            return new HttpMsg<>(Consts.ServerCode.SUCCESS, null, sid);
        }

    }
}
