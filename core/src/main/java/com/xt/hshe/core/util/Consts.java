package com.xt.hshe.core.util;

/**
 * Created by shawn on 2018/1/22.
 */
public class Consts {
    public static class ServerCode{
        public static int SUCCESS = 1;
        public static int FAILURE = 0;
    }
    public static class Auth{
        public static int OK = 1;
        public static int WRONG_PASSWORD = 0;
        public static int NOT_EXIST = -1;

    }
    public static class TopicStatus{
        public static int WAITING = -1;
        public static int RUNNING = 1;
        public static int STOPPED = 0;
    }
}
