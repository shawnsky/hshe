package com.xt.hshe.core.repository;

import com.xt.hshe.core.pojo.entity.Classes;
import com.xt.hshe.core.pojo.entity.ClassesTopic;
import com.xt.hshe.core.pojo.entity.Teacher;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ClassesTopicRepository extends CrudRepository<ClassesTopic, Long> {

    @Query(value = "select ct.classId from ClassesTopic ct where ct.topicId = ?1")
    Object findClassesByTopicId(Long arg1);

}
