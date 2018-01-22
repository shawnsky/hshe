package com.xt.hshe.core;


import com.xt.hshe.core.util.AES;
import org.springframework.util.Base64Utils;

import java.io.File;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Test {
    public static void main(String[] args) throws Exception {
        String key = "shawnchenshawnsk";
        String str = "student#140705202#"+System.currentTimeMillis();

        String example = "student#140705202#1514859111189";

//        String rgx = "[studenachr]{7}+#[0-9]{8,9}#[0-9]{13}";
//        Pattern pattern = Pattern.compile(rgx);
//        Matcher matcher = pattern.matcher(example);
//        System.out.println(matcher.matches());

//        String ss = "Vi2MOlBekOfJkcoQGvx2X4Sz9DXCtJhgYcoxXa/kW3A=";

//        System.out.println(AES.Encrypt(str, key));
//        System.out.println(AES.Decrypt(ss, key));
//        String root = System.getProperty("user.dir");
//        Runtime.getRuntime().exec("cd "+root);
//        Runtime.getRuntime().exec("cd program");


        System.out.println(System.currentTimeMillis());


    }
}
