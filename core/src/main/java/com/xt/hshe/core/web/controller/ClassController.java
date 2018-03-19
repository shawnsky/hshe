package com.xt.hshe.core.web.controller;

import com.xt.hshe.core.pojo.HttpMsg;
import com.xt.hshe.core.util.Consts;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class ClassController extends BaseController {
    @GetMapping("/c")
    public HttpMsg<List<Map<String, String>>> detail(){
        return new HttpMsg<>(Consts.ServerCode.SUCCESS, null, classService.findAllDetails());
    }

    @PostMapping("/c")
    public HttpMsg<Long> Tadd(HttpServletRequest request, HttpServletResponse response, @RequestBody Map map){
        String name = (String) map.get("name");
        Assert.hasText(name, "班级名称不能为空!");
        return new HttpMsg<>(Consts.ServerCode.SUCCESS, null, classService.addClass(name));
    }
}
