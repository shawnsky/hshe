package com.xt.hshe.core.repository;

import com.xt.hshe.core.pojo.entity.TopicProblem;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TopicProblemRepository extends CrudRepository<TopicProblem, Long> {

    List<TopicProblem> findByProblemId(Long arg);

}
