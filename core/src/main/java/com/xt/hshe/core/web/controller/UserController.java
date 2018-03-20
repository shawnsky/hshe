package com.xt.hshe.core.web.controller;

import com.xt.hshe.core.pojo.HttpMsg;
import com.xt.hshe.core.pojo.entity.Classes;
import com.xt.hshe.core.pojo.entity.Student;
import com.xt.hshe.core.util.Consts;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class UserController extends BaseController {

    @GetMapping("/u/info")
    public HttpMsg<Map<String, String> > info(HttpServletRequest request){
        Map<String, String> info = new HashMap<>();
        String role = (String) request.getAttribute("role");
        String id = (String) request.getAttribute("user_id");
        String nick = authService.findNick(Consts.Role.STUDENT.equals(role), id);
        info.put("user_role", role);
        info.put("user_id", id);
        info.put("user_nick", nick);
        return new HttpMsg<>(Consts.ServerCode.SUCCESS, null, info);
    }

    @GetMapping("/u")
    public HttpMsg<List<Map<String,String>>> TallStudents(HttpServletRequest request, HttpServletResponse response){
        List<Map<String, String>> data = new ArrayList<>();
        List<Student> studentList = authService.findAllStudent();
        for (Student s: studentList) {
            Map<String, String> map = new HashMap<>();
            map.put("id", s.getId());
            map.put("nick", s.getNickname());
            map.put("classes", authService.findClassesName(s.getClasses()));
            map.put("email", s.getEmail());
            map.put("submit", submissionService.countOfSubmit(s.getId()).toString());
            map.put("accept", submissionService.countOfAccept(s.getId()).toString());
            data.add(map);
        }
        return new HttpMsg<>(Consts.ServerCode.SUCCESS, null, data);
    }

    @PostMapping("/u")
    public HttpMsg TaddStudent(HttpServletRequest request, HttpServletResponse response, @RequestBody Map map){
        String id = (String) map.get("id");
        Assert.hasText(id, "学号不能为空!");
        String password = (String) map.get("password");
        Assert.hasText(password, "密码不能为空!");

        String classesFlag = (String) map.get("classes_flag");
        Assert.hasText(classesFlag, "班级编号不能为空!");
        String classesId = classesFlag.substring(0, classesFlag.indexOf('-'));


        int result = authService.register(Consts.Role.STUDENT, id, password, Long.parseLong(classesId));
        if (result == Consts.Auth.REGISTER_HAS_EXIST) {
            return new HttpMsg<>(result, "该学号已存在");
        } else {
            return new HttpMsg<>(result, "注册成功~");
        }

    }

    @PutMapping("/u")
    public HttpMsg TaddStudentBatch(HttpServletRequest request, HttpServletResponse response, @RequestBody Map map){
        String str0 = (String) map.get("id0");
        Assert.hasText(str0, "参数0不能为空!");
        String str1 = (String) map.get("id1");
        Assert.hasText(str1, "参数1不能为空!");
        String password = (String) map.get("password");
        Assert.hasText(password, "密码不能为空!");

        String classesFlag = (String) map.get("classes_flag");
        Assert.hasText(classesFlag, "班级编号不能为空!");
        String classesId = classesFlag.substring(0, classesFlag.indexOf('-'));


        BigInteger bi0 = new BigInteger(str0);
        BigInteger bi1 = new BigInteger(str1);
        BigInteger idLeft = bi0;
        BigInteger idRight = bi1;
        if (bi0.compareTo(bi1)>=0) {
            idLeft = bi1;
            idRight = bi0;
        }
        do {
            authService.register(Consts.Role.STUDENT, idLeft.toString(), password, Long.parseLong(classesId));
            idLeft = idLeft.add(BigInteger.ONE);
        } while (!idLeft.equals(idRight));

        return new HttpMsg<>(Consts.ServerCode.SUCCESS, "批量注册完毕~");
    }


}
