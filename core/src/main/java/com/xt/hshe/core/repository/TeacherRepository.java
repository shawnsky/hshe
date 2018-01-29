package com.xt.hshe.core.repository;

import com.xt.hshe.core.pojo.entity.Teacher;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface TeacherRepository extends CrudRepository<Teacher, String> {

    @Query(value = "select nickname from Teacher where id = ?1")
    String findNickById(String arg1);

}
