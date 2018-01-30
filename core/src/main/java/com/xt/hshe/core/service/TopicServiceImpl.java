package com.xt.hshe.core.service;

import com.xt.hshe.core.pojo.entity.Problem;
import com.xt.hshe.core.pojo.entity.Topic;
import com.xt.hshe.core.pojo.vo.ProblemListItemVo;
import com.xt.hshe.core.pojo.vo.TopicListItemVo;
import com.xt.hshe.core.pojo.vo.TopicVo;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service("topicService")
public class TopicServiceImpl extends BaseService implements TopicService{

    @Override
    public List<TopicListItemVo> findAllTopicsVo() {
        List<Object[]> objects = topicRepository.findAllTopicItemVo();
        List<TopicListItemVo> list = new ArrayList<>();
        for (Object[] os: objects) {
            TopicListItemVo vo = new TopicListItemVo();
            vo.setId((Long) os[0]);
            vo.setTitle((String) os[1]);
            vo.setCreator((String) os[2]);
            vo.setTopicStatus((Integer) os[3]);
            list.add(vo);
        }
        return list;
    }


    @Override
    public TopicVo findVo(Long topicId) {
        Topic topic = topicRepository.findOne(topicId);
        if (topic==null) {
            return null;
        }
        TopicVo vo = new TopicVo();
        vo.setId(topicId);
        vo.setTitle(topic.getTitle());
        vo.setProblemListItemVos(problemService.findProblemsVoInTopic(topicId));
        return vo;
    }

    @Override
    public String findTopicTitle(Long topicId) {
        return topicRepository.findTopicTitle(topicId);
    }
}
