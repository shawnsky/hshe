package com.xt.hshe.core.service;

import com.xt.hshe.core.pojo.entity.Student;
import com.xt.hshe.core.pojo.entity.Teacher;
import org.springframework.stereotype.Service;

import java.util.List;


public interface AuthService {

    /**
     * 系统登录
     * @param role - 身份标识
     * @param id - 用户名
     * @param password - 密码
     * @return 登陆结果
     */
    int login(String role, String id, String password);

    /**
     * 用户注册
     * @param role - 身份标识
     * @param id - 用户名
     * @param password - 密码
     * @param classesId - 班级ID
     * @return 登陆结果
     */
    int register(String role, String id, String password, Long classesId);


    /**
     * 根据身份和用户名查询昵称
     * @param isStu - 是否学生
     * @param id - 用户名
     * @return 昵称
     */
    String findNick(boolean isStu, String id);


    /**
     * 根据班级ID查询班级名称
     * @param classesId- 班级ID
     * @return 班级名称
     */
    String findClassesName(Long classesId);


    /**
     * 根据用户名查找学生
     * @param id - 用户名
     * @return 学生对象
     */
    Student findStudent(String id);


    /**
     * 查询系统内所有学生
     * @return 学生列表
     */
    List<Student> findAllStudent();


    /**
     * 查询系统内所有教师
     * @return 教师列表
     */
    List<Teacher> findAllTeacher();

}
