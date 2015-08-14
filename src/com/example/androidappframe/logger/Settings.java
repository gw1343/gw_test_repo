package com.example.androidappframe.logger;

/**
 * @author Orhan Obut
 */
public final class Settings {//日志配置类

    private int methodCount = 2;//打印方法数
    private boolean showThreadInfo = true;//展示线程

    /**
     * 决定是否显示日志
     */
    private LogLevel logLevel = LogLevel.FULL;//显示日志

    public Settings hideThreadInfo() {
        showThreadInfo = false;
        return this;
    }

    public Settings setMethodCount(int methodCount) {
        this.methodCount = methodCount;
        return this;
    }

    public Settings setLogLevel(LogLevel logLevel) {
        this.logLevel = logLevel;
        return this;
    }

    public int getMethodCount() {
        return methodCount;
    }

    public boolean isShowThreadInfo() {
        return showThreadInfo;
    }

    public LogLevel getLogLevel() {
        return logLevel;
    }
}
