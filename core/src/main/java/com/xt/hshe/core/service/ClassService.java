package com.xt.hshe.core.service;

import com.xt.hshe.core.pojo.entity.Classes;
import com.xt.hshe.core.pojo.entity.Student;

import java.util.List;
import java.util.Map;

public interface ClassService {
    /**
     * 所有班级
     */
    List<Classes> findAll();

    /**
     * 根据班级ID查询班级
     * @param id - 班级ID
     * @return 班级对象
     */
    Classes findClass(Long id);

    /**
     * 创建班级
     * @param name - 班级名称
     * @return 班级ID
     */
    long addClass(String name);


    /**
     * 查询班级内所有学生
     * @param id - 班级ID
     * @return 学生列表
     */
    List<Student> findStudents(Long id);


    /**
     * 所有班级显示对象(包含作业总数最新作业信息)
     * @return
     */
    List<Map<String, String>> findAllDetails();
}
