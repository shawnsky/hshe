package com.xt.hshe.core.service;

import com.xt.hshe.core.pojo.Student;
import com.xt.hshe.core.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("authService")
public class AuthServiceImpl extends BaseService implements AuthService {



    @Override
    public int login(String id, String password) {
        Student student = studentRepository.findOne(id);
        if (student==null) return -1;
        if (!password.equals(student.getPassword())) return 0;
        return 1;
    }

}
