package com.manage.commom.utils;

import org.apache.commons.lang3.StringUtils;

import java.math.BigDecimal;
import java.util.regex.Pattern;

/***
 *
 * 金额
 *
 * 如果需要精确计算，必须用String来够造BigDecimal！ ！！
 *
 * Java里面的商业计算，不能用float和double，因为他们无法 进行精确计算。
 * 但是Java的设计者给编程人员提供了一个很有用的类BigDecimal，
 * 他可以完善float和double类无法进行精确计算的缺憾。
 * BigDecimal类位于java.maths类包下。
 * 它的构造函数很多，最常用的:
 * BigDecimal(double val)
 * BigDecimal(String str)
 * BigDecimal(BigInteger val)
 * BigDecimal(BigInteger unscaledVal, int scale)
 *
 * Created by Administrator on 2017/3/6 0006.
 *
 */
public class AmountUtil {

    /**
     * 金额+
     * @param str1
     * @param str2
     * @return
     */
    public static String add(String str1,String str2){
        return String.valueOf((StringUtils.isBlank(str1)?BigDecimal.ZERO:new BigDecimal(str1)).add(StringUtils.isBlank(str2)?BigDecimal.ZERO:new BigDecimal(str2)).doubleValue());
    }

    /**
     * 金额-
     * @param str1
     * @param str2
     * @return
     */
    public static String sub(String str1,String str2){
        return String.valueOf((new BigDecimal(str1).subtract(StringUtils.isBlank(str2) ? BigDecimal.ZERO : new BigDecimal(str2))).doubleValue());
    }

    /**
     * 是否金额
     * @param str
     * @param pre
     * @return
     */
    public static boolean isMoney(String str, int pre) {
        String reg = "^(([1-9]\\d{0,13})|0)(\\.\\d{1,"+pre+"})?$";
        return Pattern.compile(reg).matcher(str).find();
    }

}