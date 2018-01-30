package com.xt.hshe.core.repository;

import com.xt.hshe.core.pojo.entity.TestPoint;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TestPointRepository extends CrudRepository<TestPoint, Long> {

    @Query(value = "select t from TestPoint t where t.problemId = ?1 and t.index = 0")
    TestPoint findExample(Long arg1);

    List<TestPoint> findAllByProblemId(Long arg1);

}
