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

    @Query(value = "select t from Topic t, ClassesTopic ct where ct.classId = ?1 and ct.topicId = t.id order by t.createTime DESC")
    List<Topic> findTopicByClassId(Long arg0);

    @Query(value = "select t.title from Topic t where t.id = ?1")
    String findTopicTitle(Long arg1);

    @Query(value = "SELECT t.id, t.title, u.nickname, (CASE " +
            "WHEN t.startTime>unix_timestamp(now())*1000 THEN -1 " +
            "WHEN t.endTime<unix_timestamp(now())*1000 THEN 0 " +
            "ELSE 1 END) as topicStatus FROM Topic t, Teacher u WHERE t.creator = u.id")
    List<Object[]> findAllTopicItemVo();

    long count();

}
