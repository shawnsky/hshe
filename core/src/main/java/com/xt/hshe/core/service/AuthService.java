package com.xt.hshe.core.service;

import com.xt.hshe.core.pojo.entity.Student;
import com.xt.hshe.core.pojo.entity.Teacher;
import org.springframework.stereotype.Service;

import java.util.List;


public interface AuthService {
    int login(String role, String id, String password);

    int register(String role, String id, String password, Long classesId);

    String findNick(boolean isStu, String id);

    String findClassesName(Long classesId);

    List<Student> findAllStudent();

    List<Teacher> findAllTeacher();

}
