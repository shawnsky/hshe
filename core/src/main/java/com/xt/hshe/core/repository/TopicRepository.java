package com.xt.hshe.core.repository;

import com.xt.hshe.core.pojo.entity.Topic;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TopicRepository extends CrudRepository<Topic, Long> {
    List<Topic> findAll();

}
