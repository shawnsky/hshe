package com.xt.hshe.core.repository;

import com.xt.hshe.core.pojo.entity.Student;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface StudentRepository extends CrudRepository<Student, String> {


    @Query(value = "select nickname from Student where id = ?1")
    String findNickById(String arg1);

    List<Student> findAll();

    @Query(value = "select s from Student s where s.classes = ?1")
    List<Student> findAllByClasses(Long classesId);
}
