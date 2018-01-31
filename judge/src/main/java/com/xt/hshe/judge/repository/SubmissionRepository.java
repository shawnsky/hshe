package com.xt.hshe.judge.repository;


import com.xt.hshe.judge.pojo.entity.Submission;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;

public interface SubmissionRepository extends CrudRepository<Submission, Long> {
    @Modifying
    @Transactional
    @Query("update Submission s set s.judged = ?2 where s.id = ?1")
    Integer updateJudged(Long sid, Integer result);
}
