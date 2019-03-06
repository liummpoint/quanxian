package com.manage.commom.utils;


import com.manage.commom.enums.ErrorCode;
import com.manage.commom.exception.MessageException;
import com.manage.commom.exception.ValidateException;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 参数校验工具类
 *
 * @author donglei
 * @since 2016-08-09
 */
public class ParamValidUtil {
    private static Logger LOGGER = LoggerFactory.getLogger(ParamValidUtil.class);

    /**
     * 校验对象是否为空
     *
     * @param name
     * @param value
     * @throws ValidateException
     */
    public static void checkNull(String name, Object value) throws ValidateException {
        if (value == null) {
            throw new ValidateException(ErrorCode.BUSSINESS_ERROR_0002, name + "不能为空");
        }
    }

    /**
     * 校验字符串是否为空
     *
     * @param name
     * @param value
     * @throws ValidateException
     */
    public static void checkNull(String name, String value) throws ValidateException {
        if (StringUtils.isBlank(value)) {
            throw new ValidateException(ErrorCode.BUSSINESS_ERROR_0002, name + "不能为空");
        }
    }

    /**
     * 校验集合是否为空
     *
     * @param name
     * @param value
     * @throws ValidateException
     */
    public static void checkNull(String name, List value) throws ValidateException {
        if (value == null || value.isEmpty()) {
            throw new ValidateException(ErrorCode.BUSSINESS_ERROR_0002, name + "不能为空");
        }
    }

    /**
     * 校验Map是否为空
     *
     * @param name
     * @param value
     * @throws ValidateException
     */
    public static void checkNull(String name, Map value) throws ValidateException {
        if (value == null || value.isEmpty()) {
            throw new ValidateException(ErrorCode.BUSSINESS_ERROR_0002, name + "不能为空");
        }
    }

    /**
     * 校验字符串长度是否超过指定位数
     *
     * @param name
     * @param value
     * @param length
     * @throws ValidateException
     */
    public static void checkLength(String name, String value, int length) throws ValidateException {
        if (StringUtils.isNotBlank(value) && value.length() > length) {
            throw new ValidateException(ErrorCode.BUSSINESS_ERROR_0002, name + "不能超过" + length + "位");
        }
    }

    /**
     * 校验字符串是否为空,长度是否超过指定位数
     *
     * @param name
     * @param value
     * @param length
     * @throws ValidateException
     */
    public static void checkNullAndLength(String name, String value, int length) throws ValidateException {
        checkNull(name, value);
        checkLength(name, value, length);
    }

    /**
     * 校验交易日期
     *
     * @param name
     * @param value
     * @param length
     * @param formatter
     */
    public static void checkTransDate(String name, String value, int length, String formatter) {
        checkNull(name, value);
        if (value.length() != length) {
            throw new ValidateException(ErrorCode.BUSSINESS_ERROR_0002, name + "应该等于" + length + "位");
        }
        SimpleDateFormat format = new SimpleDateFormat(formatter);
        try {
            format.parse(value);
        } catch (ParseException e) {
            throw new ValidateException(ErrorCode.BUSSINESS_ERROR_0002, name + "格式不正确");
        }
    }

    /**
     * 校验金额是否大于等于0，是否超过上限
     *
     * @param name
     * @param value
     * @throws ValidateException
     */
    public static void checkAmount(String name, Long value) throws ValidateException {
        if (null != value) {
            if (!(value >= 0 && value < 9999999999999999l)) {
                throw new ValidateException(ErrorCode.BUSSINESS_ERROR_0002, "金额" + name + "必须大于等于0，且小于金额上限");
            }
        }
    }

    /**
     * 校验金额金额是否为空,长度是否超过指定位数，是否大于0，是否超过上限
     *
     * @param name
     * @param value
     * @param length
     * @throws ValidateException
     */
    public static void checkIsAmount(String name, Long value, int length) throws ValidateException {
        checkNullAndLength(name, StringUtil.valueOf(value), length);

        checkAmount(name, value);
    }

    /**
     * 校验金额是否满足必填金额的条件
     *
     * @param name
     * @param value
     * @param length
     * @return
     */
    public static boolean checkIsRequiredMoney(String name, Long value, int length) {
        boolean flag = true;
        try {
            checkNullAndLength(name, StringUtil.valueOf(value), length);
            checkAmount(name, value);
        } catch (ValidateException e) {
            flag = false;
        }
        return flag;
    }

    /**
     * 校验是否为空,校验是否是数字
     *
     * @param name
     * @param value
     * @param length
     * @throws ValidateException
     */
    public static void checkNumber(String name, long value, int length) throws ValidateException {
        checkLength(name, String.valueOf(value), length);
        checkAmount(name, value);
    }

    /**
     * 检验业务编码
     *
     * @param inputFuncId 传入的业务编码
     */
    public static void checkFuncId(String inputFuncId, List<String> funcIdList) {
        if (!(null != funcIdList && funcIdList.size() > 0)) {
            throw new ValidateException(ErrorCode.BUSSINESS_ERROR_0002, "调用的业务参数不能为空");
        }
        // 校验业务编码
        if (StringUtils.isBlank(inputFuncId)) {
            throw new ValidateException(ErrorCode.BUSSINESS_ERROR_0002, "传入的业务编码不能为空");
        }
        if (!funcIdList.contains(inputFuncId)) {
            throw new ValidateException(ErrorCode.BUSSINESS_ERROR_0002, "传入的业务编码与调用的业务编码不一致");
        }
    }

    /**
     * 校验非必填金额
     *
     * @param value
     * @throws ValidateException
     */
    public static void checkNotRequiredAmount(Long value) throws ValidateException {
        if (null != value) {
            if (!(value >= 0 && value < 9999999999999999L)) {
                throw new ValidateException(ErrorCode.BUSSINESS_ERROR_0002, "金额必须大于等于0，且小于金额上限");
            }
        }
    }

    /**
     * 校验InPut类中的moneyMap中的参数
     *
     * @param moneyMap        InPut类中的moneyMap
     * @param requiredCodeArr 必填的金额code
     */
    public static void checkMoneyMap(Map<String, Long> moneyMap, String[] requiredCodeArr) {

        if (null == moneyMap) {
            throw new ValidateException(ErrorCode.BUSSINESS_ERROR_0002, "moneyMap不能为空");
        }

        //先检验所有金额，可以为null，可以为0，但是不为null时，长度、大小必须在范围之内
        for (String key : moneyMap.keySet()) {
            Long value = moneyMap.get(key);
            if (null != value) {
                checkLength(key, String.valueOf(moneyMap.get(key) + ""), 20);
                checkAmount(key, moneyMap.get(key));
            }
        }

        //检验所有必填金额code的金额，不能为null,不能为0，长度、大小必须在范围之内
        for (String requeredCode : requiredCodeArr) {
            checkIsAmount(requeredCode, moneyMap.get(requeredCode), 20);
        }

    }

    /**
     * 校验InPut类中的moneyMap中的参数
     *
     * @param moneyMap
     * @param requiredCodeArr 至少有一个必输项的金额code数组
     */
    public static void checkRequiredInMoneyMap(Map<String, Long> moneyMap, String[] requiredCodeArr) {
        if (null == moneyMap) {
            throw new ValidateException(ErrorCode.BUSSINESS_ERROR_0002, "moneyMap不能为空");
        }

        //先检验所有金额，可以为null，可以为0，但是不为null时，长度、大小必须在范围之内
        for (String key : moneyMap.keySet()) {
            Long value = moneyMap.get(key);
            if (null != value) {
                checkLength(key, String.valueOf(moneyMap.get(key) + ""), 20);
                checkAmount(key, moneyMap.get(key));
            }
        }

        boolean result = false;
        //检验所有必填金额code的金额，不能为null,不能为0，长度、大小必须在范围之内
        for (String requeredCode : requiredCodeArr) {
            if (checkIsRequiredMoney(requeredCode, moneyMap.get(requeredCode), 20)) {
                result = true;
            }
        }
        if (!result) {
            throw new ValidateException(ErrorCode.BUSSINESS_ERROR_0002, "至少有一个金额必输项的moneyMap参数不合法");
        }
    }

    /**
     * 校验开始时间和结束时间不得超过三个月
     *
     * @param startDate
     * @param endDate
     */
    public static void checkStartDateAndEndDate(Date startDate, Date endDate) {
        if (startDate == null || endDate == null) {
            return;
        }
        Calendar cal = Calendar.getInstance();
        Date date = DateUtil.rollMon(startDate, 3);
        cal.setTime(date);
        long time1 = cal.getTimeInMillis();
        cal.setTime(endDate);
        long time2 = cal.getTimeInMillis();
        if (time1 - time2 < 0) {
            throw new ValidateException(ErrorCode.BUSSINESS_ERROR_0002, "账户流水查询开始时间和结束时间相隔不能超过三个月");
        }

    }

    /**
     * flag为true，抛出messageException异常
     *
     * @param flag
     * @param messageException
     * @param errorLog         flag为true时，打印的错误日志
     */
    public static void isTrue(boolean flag, MessageException messageException, String errorLog) {
        if (flag) {
            // 打印错误日志
            LOGGER.error(errorLog);
            throw messageException;
        }
    }

    /**
     * 比较String类型金额与Long类型金额是否相等
     *
     * @param strName String类型金额名称
     * @param str     String类型金额
     * @param money   Long类型金额
     * @return
     */
    public static void compareAmount(String strName, String str, Long money) {
        if (StringUtils.isBlank(str)) {
            throw new ValidateException(ErrorCode.BUSSINESS_ERROR_0002, "String类型金额str不能为空");
        }
        try {
            Long amount = Long.valueOf(str);
            if (!amount.equals(money)) {
                throw new ValidateException(ErrorCode.BUSSINESS_ERROR_0002, strName + "参数不合法");
            }
        } catch (NumberFormatException e) {
            LOGGER.error("比较String类型金额与Long类型金额是否相等异常", e);
            throw new ValidateException(ErrorCode.BUSSINESS_ERROR_0002, strName + "参数不合法");
        }
    }


    /**
     * 字符串类型金额校验
     *
     * @param amount     金额字符串
     * @param isRequired 是否必填
     */
    public static Long checkAmount(String strName, String amount, boolean isRequired) {
        if (isRequired) {
            if (StringUtils.isBlank(amount)) {
                throw new ValidateException(ErrorCode.BUSSINESS_ERROR_0002, strName + "不能为空");
            }
            amount = amount.trim();
            Pattern p = Pattern.compile("[0-9]*");
            Matcher m = p.matcher(amount);
            boolean result = m.matches();

            if (result) {
                long value = Long.parseLong(amount);
                if (value == 0) {
                    throw new ValidateException(ErrorCode.BUSSINESS_ERROR_0002, strName + "必须为正整数");
                }
                return value;
            } else {
                throw new ValidateException(ErrorCode.BUSSINESS_ERROR_0002, strName + "必须为正整数");
            }


        } else {
            if (!StringUtils.isBlank(amount)) {
                amount = amount.trim();
                Pattern p = Pattern.compile("[0-9]*");
                Matcher m = p.matcher(amount);
                boolean result = m.matches();
                if (result) {
                    return Long.valueOf(amount);
                } else {
                    throw new ValidateException(ErrorCode.BUSSINESS_ERROR_0002, strName + "必须为非负整数或者空");
                }
            }
            return null;
        }

    }

    /**
     * 校验金额是否大于0，是否超过上限
     *
     * @param name
     * @param value
     * @throws ValidateException
     */
    public static void checkAmountAllowZero(String name, long value) throws ValidateException {
        if (value < 0) {
            throw new ValidateException(ErrorCode.BUSSINESS_ERROR_0002, name + "必须大于0");
        }
        if (value > 9999999999999999l) {
            throw new ValidateException(ErrorCode.BUSSINESS_ERROR_0002, name + "超过金额上限");
        }
    }

    /**
     * 校验金额是否大于0，是否超过上限
     *
     * @param name
     * @param value
     * @throws ValidateException
     */
    public static void checkAmountAllowZero(String name, Long value) throws ValidateException {
        checkNull(name, value);
        checkAmountAllowZero(name, value.intValue());
    }

    /**
     *  校验手机号
     */
    public static void checkMobileAndLength(String name,String value) throws ValidateException {
        checkNull(name,value);
        checkMobile(name,value);
    }

    private static void checkMobile(String name, String value) {
        String relx = "^(13[0-9]|14[0-9]|15[0-9]|18[0-9]|17[0-9])\\d{8}$";
        if(!value.matches(relx)){
            throw new ValidateException(ErrorCode.BUSSINESS_ERROR_0002, name + "手机号不合法");
        }
    }

    public static void main(String[] args){
        try{
            checkMobile("mo", "17722222222");
        } catch (Exception e){
            e.printStackTrace();
            System.out.println("123123");
        }
    }
    public static void checkIdcardAndLength(String name,String value) throws ValidateException{
        checkNull(name,value);
        checkIdcard(name,value);
    }

    private static void checkIdcard(String name, String value) {
        String relx = "^\\d{18}|[0-9x]{18}|[0-9X]{18}|\\d{15}?$";
        if(!value.matches(relx)){
            throw new ValidateException(ErrorCode.BUSSINESS_ERROR_0002, name + "身份证号不合法");
        }

    }

    public static void checkNullAndNumber(String name, String value, int lengthStart,int lengthEnd) {
        checkNull(name,value);
        checknumber(name,value,lengthStart,lengthEnd);
    }

    private static void checknumber(String name, String value,int lengthStart, int lengthEnd) {
        String relx = "^\\d{"+lengthStart+","+lengthEnd+"}?$";
        if(!value.matches(relx)){
            throw new ValidateException(ErrorCode.BUSSINESS_ERROR_0002, name + "不合法");
        }
    }
    public static void checkNullAndIp(String name,String value){
        checkNull(name,value);
        checkIp(name,value);
    }

    private static void checkIp(String name, String value) {
        String relx = "((?:(?:25[0-5]|2[0-4]\\d|((1\\d{2})|([1-9]?\\d)))\\.){3}(?:25[0-5]|2[0-4]\\d|((1\\d{2})|([1-9]?\\d))))";
        if(!value.matches(relx)){
            throw new ValidateException(ErrorCode.BUSSINESS_ERROR_0002, name + "Ip不合法");
        }
    }

}
