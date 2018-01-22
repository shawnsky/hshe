package com.xt.hshe.core.repository;

import com.xt.hshe.core.pojo.entity.Topic;
import com.xt.hshe.core.pojo.vo.TopicListItemVo;
import com.xt.hshe.core.pojo.vo.TopicVo;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.HashMap;
import java.util.List;

public interface TopicRepository extends CrudRepository<Topic, Long> {
    List<Topic> findAll();

    @Query(value = "SELECT t.id, t.title, u.nickname, (CASE " +
            "WHEN t.startTime>unix_timestamp(now())*1000 THEN -1 " +
            "WHEN t.endTime<unix_timestamp(now())*1000 THEN 0 " +
            "ELSE 1 END) as topicStatus FROM Topic t, Teacher u WHERE t.creator = u.id")
    List<Object[]> findAllTopicItemVo();
}
