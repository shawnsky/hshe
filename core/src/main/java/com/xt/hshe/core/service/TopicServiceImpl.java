package com.xt.hshe.core.service;

import com.xt.hshe.core.pojo.entity.Topic;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("topicService")
public class TopicServiceImpl extends BaseService implements TopicService{
    @Override
    public List<Topic> findAll() {
        return topicRepository.findAll();
    }
}
