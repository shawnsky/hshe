package com.xt.hshe.core.util;

/**
 * Created by shawn on 2018/1/22.
 */
public class Consts {
    public static class ServerCode{
        public static final int SUCCESS = 1;
        public static final int FAILURE = 0;
    }
    public static class Auth{
        public static final int OK = 1;
        public static final int WRONG_PASSWORD = 0;
        public static final int NOT_EXIST = -1;

    }
    public static class TopicStatus{
        public static final int WAITING = -1;
        public static final int RUNNING = 1;
        public static final int STOPPED = 0;
    }
    public static class Language{
        public static final String C = "c";
        public static final String CPP = "cpp";
        public static final String JAVA = "java";
        public static final String PYTHON = "py";
        public static final String RUBY = "rb";
        public static final String GO = "go";
        public static final String PERL = "pl";
    }
}
