package com.xt.hshe.judge;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String s =  "java -classpath {pathname} Main";
        String p = "/data/subs/1/10/Main";
        String n = s.replaceAll("\\{pathname\\}", p.substring(0, p.indexOf("Main")));
        System.out.println(n);

    }
}
