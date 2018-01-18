package com.xt.hshe.core;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegTest {
    public static void main(String[] args) {
        String uri = "/auth/login";
        String regex = "/auth]";
        String s = "/auth[a-zA-Z_0-9/]*";
        Pattern pattern = Pattern.compile(s);
        Matcher matcher = pattern.matcher(uri);
        System.out.println(matcher.matches());
    }
}
