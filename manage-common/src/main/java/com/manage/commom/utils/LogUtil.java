package com.manage.commom.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;

public class LogUtil {
    private static final Logger logger = LoggerFactory.getLogger(LogUtil.class);

    /**
     * 打印请求日志
     * @param content  日志内容
     */
    public static void printRequestLog(String content) {
        logger.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>" + content + DateUtil.dateStr(new Date(), DateUtil.DATEFORMAT_STR_025));
    }

    /**
     * 打印请求日志
     * @param content 日志内容
     * @param paramObject  参数
     */
    public static void printRequestLog(String content, Object paramObject) {
        logger.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>" + content + DateUtil.dateStr(new Date(), DateUtil.DATEFORMAT_STR_025), paramObject);
    }

    /**
     * 打印响应日志
     * @param content 日志内容
     */
    public static void printResponseLog(String content) {
        logger.info("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<" + content + DateUtil.dateStr(new Date(), DateUtil.DATEFORMAT_STR_025));
    }

    /**
     * 打印响应日志
     * @param content 日志内容
     * @param paramObject 参数
     */
    public static void printResponseLog(String content, Object paramObject) {
        logger.info("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<" + content + DateUtil.dateStr(new Date(), DateUtil.DATEFORMAT_STR_025), paramObject);
    }

    /**
     * 打印错误日志
     * @param content 日志内容
     */
    public static void printResponseErrorLog(String content,Exception e) {
        logger.error("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<" + content + DateUtil.dateStr(new Date(), DateUtil.DATEFORMAT_STR_025),e);
    }
    /**
     * 打印错误日志
     * @param content 日志内容
     * @param paramObject 参数
     */
    public static void printResponseErrorLog(String content, Object paramObject,Exception e) {
        logger.info("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<" + content + DateUtil.dateStr(new Date(), DateUtil.DATEFORMAT_STR_025), paramObject,e);
    }
}
