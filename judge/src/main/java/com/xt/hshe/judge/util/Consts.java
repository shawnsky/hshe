package com.xt.hshe.judge.util;

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
    public static class Judge{
        public static final int AC = 0; //通过
        public static final int WA = 1; //答案错误
        public static final int TLE = 2; //时间超限
        public static final int OLE = 3; //输出超限
        public static final int MLE = 4; //内存超限
        public static final int RE = 5; //运行时错误
        public static final int PE = 6; //格式错误
        public static final int CE = 7; //编译错误
        public static final int SE = 8; //系统错误
    }
}
