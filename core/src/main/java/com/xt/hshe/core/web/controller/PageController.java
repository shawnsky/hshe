package com.xt.hshe.core.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class PageController {
    @GetMapping("/")
    public String index(HttpServletRequest request){
        if (request.getHeader("token")==null)
            return "redirect:/login";
        return "redirect:/topic";
    }


    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @GetMapping("/rank")
    public String rank(){
        return "rank";
    }



    @GetMapping("/topic")
    public String allTopic(){
        return "topic";
    }
    @GetMapping("/topic/{id}")
    public String topicDetail(@PathVariable String id, Model model){
        model.addAttribute("pathId",id);
        return "problem";
    }


    @GetMapping("/problem")
    public String allProblem(){
        return "problem";
    }
    @GetMapping("/problem/{id}")
    public String problemDetail(@PathVariable String id, Model model){
        model.addAttribute("pathId",id);
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







}
