package com.xt.hshe.core.service;

import com.xt.hshe.core.pojo.entity.Student;
import com.xt.hshe.core.pojo.entity.Teacher;
import com.xt.hshe.core.util.Consts;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("authService")
public class AuthServiceImpl extends BaseService implements AuthService {


    @Override
    public int login(String role, String id, String password) {
        if (Consts.Role.STUDENT.equals(role)) {
            Student recordstu = studentRepository.findOne(id);
            if (recordstu==null) return Consts.Auth.LOGIN_NOT_EXIST;
            if (!password.equals(recordstu.getPassword())) return Consts.Auth.LOGIN_WRONG_PASSWORD;
            return Consts.Auth.LOGIN_OK;
        } else {
            Teacher recordtea = teacherRepository.findOne(id);
            if (recordtea==null) return Consts.Auth.LOGIN_NOT_EXIST;
            if (!password.equals(recordtea.getPassword())) return Consts.Auth.LOGIN_WRONG_PASSWORD;
            return Consts.Auth.LOGIN_OK;
        }

    }

    @Override
    public int register(String role, String id, String password, Long classesId) {
        if (Consts.Role.STUDENT.equals(role)) {
            Student recordstu = studentRepository.findOne(id);
            //用户已存在
            if (recordstu != null) {
                return Consts.Auth.REGISTER_HAS_EXIST;
            } else {
                Student student = new Student();
                student.setId(id);
                student.setPassword(password);
                student.setClasses(classesId);
                studentRepository.save(student);
                return Consts.Auth.REGISTER_OK;
            }
        } else {
            Teacher recordtea = teacherRepository.findOne(id);
            if (recordtea != null) {
                return Consts.Auth.REGISTER_HAS_EXIST;
            } else {
                Teacher teacher = new Teacher();
                teacher.setId(id);
                teacher.setPassword(password);
                teacherRepository.save(teacher);
                return Consts.Auth.REGISTER_OK;
            }
        }
    }

    @Override
    public String findNick(boolean isStu, String id) {
        if (isStu) {
            return studentRepository.findNickById(id);
        } else {
            return teacherRepository.findNickById(id);
        }
    }

    @Override
    public String findClassesName(Long classesId) {
        return (String) classesRepository.findNameById(classesId);
    }

    @Override
    public Student findStudent(String id) {
        return studentRepository.findOne(id);
    }


    @Override
    public List<Student> findAllStudent() {
        return studentRepository.findAll();
    }

    @Override
    public List<Teacher> findAllTeacher() {
        return teacherRepository.findAll();
    }

}
