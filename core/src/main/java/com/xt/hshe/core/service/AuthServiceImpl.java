package com.xt.hshe.core.service;

import com.xt.hshe.core.pojo.entity.Student;
import com.xt.hshe.core.util.Consts;
import org.springframework.stereotype.Service;

@Service("authService")
public class AuthServiceImpl extends BaseService implements AuthService {



    @Override
    public int login(String id, String password) {
        Student student = studentRepository.findOne(id);
        if (student==null) return Consts.Auth.NOT_EXIST;
        if (!password.equals(student.getPassword())) return Consts.Auth.WRONG_PASSWORD;
        return Consts.Auth.OK;
    }

}
