package com.xt.hshe.core.service;

import com.xt.hshe.core.pojo.Topic;
import com.xt.hshe.core.repository.TopicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("topicService")
public class TopicServiceImpl extends BaseService implements TopicService{
    @Override
    public List<Topic> findAll() {
        return topicRepository.findAll();
    }
}
