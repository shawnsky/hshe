package com.xt.hshe.core.repository;

import com.xt.hshe.core.pojo.entity.Student;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface StudentRepository extends CrudRepository<Student, String> {

    List<Student> findByNickname(String nickname);

    @Query(value = "select id,nickname,password,email from student where email = ?1", nativeQuery = true)
    List<Student> findNoEmail(String arg1);
}
