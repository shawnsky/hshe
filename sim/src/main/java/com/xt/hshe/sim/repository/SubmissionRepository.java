package com.xt.hshe.sim.repository;



import com.xt.hshe.sim.pojo.entity.Submission;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;


import javax.transaction.Transactional;
import java.util.List;

public interface SubmissionRepository extends CrudRepository<Submission, Long> {
    @Modifying
    @Transactional
    @Query("update Submission s set s.judged = ?2, s.memoryUsed = ?3, s.timeUsed = ?4 where s.id = ?1")
    Integer updateJudged(Long sid, Integer result, Integer memUsed, Integer timeUsed);

    @Query("select s from Submission s where s.problemId = ?1 and s.userId <> ?2")
    List<Submission> findOtherUserSubmission(Long arg1, String arg2);

}
