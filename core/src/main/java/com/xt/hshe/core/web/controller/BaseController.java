package com.xt.hshe.core.web.controller;

import com.xt.hshe.core.service.AuthService;
import com.xt.hshe.core.service.ProblemService;
import com.xt.hshe.core.service.SubmissionService;
import com.xt.hshe.core.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;

public class BaseController {

    @Autowired
    protected StringRedisTemplate redisTemplate;

    @Autowired
    protected AuthService authService;

    @Autowired
    protected TopicService topicService;

    @Autowired
    protected ProblemService problemService;

    @Autowired
    protected SubmissionService submissionService;


}
