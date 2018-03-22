package com.xt.hshe.core.web.controller;

import com.xt.hshe.core.mq.Sender;
import com.xt.hshe.core.service.*;
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

    @Autowired
    protected ClassService classService;

    @Autowired
    protected MasterService masterService;

    @Autowired
    protected Sender sender;


}
