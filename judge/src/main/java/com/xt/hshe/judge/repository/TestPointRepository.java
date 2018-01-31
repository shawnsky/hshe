package com.xt.hshe.judge.repository;

import com.xt.hshe.judge.pojo.entity.TestPoint;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TestPointRepository extends CrudRepository<TestPoint, Long> {

    List<TestPoint> findAllByProblemId(Long arg1);

}
