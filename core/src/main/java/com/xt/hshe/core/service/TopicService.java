package com.xt.hshe.core.service;

import com.xt.hshe.core.pojo.entity.Classes;
import com.xt.hshe.core.pojo.vo.TopicListItemVo;
import com.xt.hshe.core.pojo.vo.TopicVo;

import java.util.List;

public interface TopicService {
    List<TopicListItemVo> findAllTopicsVo();
    TopicVo findVo(Long topicId);
    String findTopicTitle(Long topicId);
    long add(Long classId,String title, String desc, String beginTime, String endTime, String creator);
    Classes findClasses(Long topicId);
}
