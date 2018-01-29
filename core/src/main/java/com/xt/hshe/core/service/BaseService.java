package com.xt.hshe.core.service;

import com.xt.hshe.core.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;

public class BaseService {
    @Autowired
    protected StringRedisTemplate redisTemplate;

    @Autowired
    protected ClassesRepository classesRepository;
    @Autowired
    protected ProblemRepository problemRepository;
    @Autowired
    protected StudentRepository studentRepository;
    @Autowired
    protected TeacherRepository teacherRepository;
    @Autowired
    protected TestPointRepository testPointRepository;
    @Autowired
    protected TopicRepository topicRepository;
    @Autowired
    protected SubmissionRepository submissionRepository;

    @Autowired
    protected ProblemService problemService;
    @Autowired
    protected AuthService authService;
}
