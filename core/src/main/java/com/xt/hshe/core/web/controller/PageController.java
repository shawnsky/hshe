package com.xt.hshe.core.web.controller;

import com.xt.hshe.core.mq.Sender;
import com.xt.hshe.core.pojo.entity.Submission;
import com.xt.hshe.core.util.Consts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class PageController {

    @GetMapping("/")
    public String index(){
        return "redirect:/topic";
    }


    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @GetMapping("/master")
    public String master(){
        return "master";
    }



    @GetMapping("/topic")
    public String allTopic(){
        return "topic";
    }
    @GetMapping("/topic/{id}")
    public String topicDetail(){
        return "problem";
    }


    @GetMapping("/problem")
    public String allProblem(){
        return "problem";
    }
    @GetMapping("/problem/{id}")
    public String problemDetail(){
        return "problem_detail";
    }


    @GetMapping("/submission")
    public String allSubmission(){
        return "submit";
    }
    @GetMapping("/submission/{id}")
    public String SubmissionDetail(@PathVariable String id, Model model){
        model.addAttribute("pathId",id);
        return "submit_detail";
    }

    @GetMapping("/cookie")
    @ResponseBody
    public Cookie[] cookie(HttpServletRequest request){
        return request.getCookies();
    }







}
