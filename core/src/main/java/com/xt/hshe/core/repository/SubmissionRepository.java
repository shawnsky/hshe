package com.xt.hshe.core.repository;


import com.xt.hshe.core.pojo.entity.Submission;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface SubmissionRepository extends CrudRepository<Submission, Long> {

    List<Submission> findAll();

    @Query("select s from Submission s where s.problemId = ?1")
    List<Submission> findByProblemId(Long arg1);

    @Query("select s from Submission s where s.userId = ?1")
    List<Submission> findByUserId(String arg1);

    Long countByUserId(String arg1);

    Long countByUserIdAndJudged(String arg0, Integer arg1);

}
