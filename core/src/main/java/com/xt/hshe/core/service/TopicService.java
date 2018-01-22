package com.xt.hshe.core.service;

import com.xt.hshe.core.pojo.entity.Topic;
import com.xt.hshe.core.pojo.vo.ProblemListItemVo;
import com.xt.hshe.core.pojo.vo.TopicListItemVo;
import com.xt.hshe.core.pojo.vo.TopicVo;

import java.util.HashMap;
import java.util.List;

public interface TopicService {
    List<TopicListItemVo> findAllTopicsVo();
    TopicVo findVo(Long topicId);
}
