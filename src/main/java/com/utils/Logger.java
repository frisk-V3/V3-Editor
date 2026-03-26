package com.utils;

import java.time.LocalTime;

public class Logger {

    public interface LogTarget {
        void log(String text);
    }

    private static LogTarget target;

    public static void setTarget(LogTarget t) {
        target = t;
    }

    public static void info(String msg) {
        if (target != null) target.log("[INFO " + LocalTime.now() + "] " + msg);
    }

    public static void error(String msg) {
        if (target != null) target.log("[ERROR " + LocalTime.now() + "] " + msg);
    }
}
