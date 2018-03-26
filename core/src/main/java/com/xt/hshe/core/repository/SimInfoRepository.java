package com.xt.hshe.core.repository;


import com.xt.hshe.core.pojo.entity.SimInfo;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface SimInfoRepository extends CrudRepository<SimInfo, Long> {

    List<SimInfo> findAll();

    List<SimInfo> findByProblemId(Long arg);

    @Query(value = "select s from SimInfo s where s.problemId = ?1 and s.similarity >= 85")
    List<SimInfo> findAbsoluteByProblemId(Long arg);

    SimInfo findBySourceSid(Long arg);




}
