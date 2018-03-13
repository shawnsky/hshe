package com.xt.hshe.core.web.controller;

import com.xt.hshe.core.pojo.HttpMsg;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class MasterController extends BaseController {
    @GetMapping("/statistics")
    public HttpMsg Tstatistics(HttpServletRequest request, HttpServletResponse response){
        Map<String, String> data = new HashMap<>();

        return null;
    }
}
