package com.xt.hshe.core;

public class LenTest {
    public static void main(String[] args) {
        String str = "123/topic/2";
        System.out.println(str.indexOf("/topic/"));
        System.out.println(str.substring(str.indexOf("/topic/")+7));
        int i;


    }
}
