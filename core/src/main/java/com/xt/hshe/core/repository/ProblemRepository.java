package com.xt.hshe.core.repository;

import com.xt.hshe.core.pojo.entity.Problem;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProblemRepository extends CrudRepository<Problem, Long> {
    List<Problem> findAll();


    @Query(value = "select p.* from topic_problem tp, problem p where tp.topic_id = ?1 and tp.problem_id = p.id", nativeQuery = true)
    List<Problem> findByTopicId(Long arg1);


}
