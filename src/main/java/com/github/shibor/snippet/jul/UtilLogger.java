package com.github.shibor.snippet.jul;

import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * 使用java.util.logging.Logger
 * <p>
 * https://docs.oracle.com/javase/8/docs/technotes/guides/logging/overview.html
 */
public class UtilLogger {

    static Logger logger = Logger.getLogger("testLogger");

    public static void main(String[] args) {

        // 不能改变console的级别，只能改变输出到文件的日志的级别。
        logger.setLevel(Level.ALL);
        log();

        // 自定义consolehandler改变日志级别
        ConsoleHandler consoleHandler = new ConsoleHandler();
        consoleHandler.setLevel(Level.ALL);

        logger.addHandler(consoleHandler);
        System.out.println("设置consoleHandler后");
        log();

        // 也可以 修改JRE中lib/logging.properties文件改变日志级别
        // 也可以 通过LogManager读取自定义地配置文件
    }

    private static void log() {
        // 严重
        logger.severe("logger severe");
        // 警告
        logger.warning("logger warning");
        // 信息
        logger.info("logger info");
        // 配置
        logger.config("logger config");
        //
        logger.fine("logger fine");
        logger.finer("logger finer");
        logger.finest("logger finest");
    }
}
