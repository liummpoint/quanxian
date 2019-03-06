package com.manage.commom.utils;/**
 * Created by 59458 on 2017/6/14.
 */

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

/**
 * ConfigUtils
 * Description 配置信息初始化util类
 * Copyrigth(C),2017,lx86468@126.com.com
 * Date 2017/6/14
 *
 * @author lixiao on 2017/6/14.
 * @version 1.0
 */
@Component
@Lazy(false)
public class ConfigUtils {

    public static String hsUrl;

    public static String getBadInfo_url() {
        return hsUrl;
    }
    @Value("${huasheng.url}")
    public  void setBadInfo_url(String hsUrl) {
        ConfigUtils.hsUrl = hsUrl;
    }
}