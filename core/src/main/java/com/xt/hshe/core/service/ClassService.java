package com.xt.hshe.core.service;

import com.xt.hshe.core.pojo.entity.Classes;
import com.xt.hshe.core.pojo.entity.Student;

import java.util.List;
import java.util.Map;

public interface ClassService {
    List<Classes> findAll();
    Classes findClass(Long id);
    long addClass(String name);

    List<Student> findStudents(Long id);


    List<Map<String, String>> findAllDetails();
}