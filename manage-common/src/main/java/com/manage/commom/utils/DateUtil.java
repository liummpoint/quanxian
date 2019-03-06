package com.manage.commom.utils;


import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 工具类-日期处理
 * 
 * @author xx
 * @version 2.0
 * @since 2014年1月28日
 */
public class DateUtil {
	
	/** 格式 ：yyyy-MM-dd HH:mm:ss */
	public static final String DATEFORMAT_STR_001 = "yyyy-MM-dd HH:mm:ss";
	/** 格式 ：yyyy-MM-dd */
	public static final String DATEFORMAT_STR_002 = "yyyy-MM-dd";
	/** 格式 ：MM-dd */
	public static final String DATEFORMAT_STR_003 = "MM-dd";
	/** 格式 ：HH:mm:ss */
	public static final String DATEFORMAT_STR_004 = "HH:mm:ss";
	/** 格式 ：HH:mm:ss */
	public static final String DATEFORMAT_STR_005 = "HHmmss";
	/** 格式 ：HH:mm:ss:SSS */
	public static final String DATEFORMAT_STR_006 = "HH:mm:ss:SSS";
	
	/** 格式 ：yyyyMMddHHmmss */
	public static final String DATEFORMAT_STR_011 = "yyyyMMddHHmmss";
	/** 格式 ：yyyyMMdd */
	public static final String DATEFORMAT_STR_012 = "yyyyMMdd";
	
	/** 格式 ：yyyy年MM月dd日 HH时mm分ss秒 */
	public static final String DATEFORMAT_STR_021 = "yyyy年MM月dd日 HH时mm分ss秒";
	/** 格式 ：yyyy年MM月dd日 */
	public static final String DATEFORMAT_STR_022 = "yyyy年MM月dd日";
	/** 格式 ：MM月dd日 hh:mm */
	public static final String DATEFORMAT_STR_023 = "MM月dd日 hh:mm";
	/** 格式 ：yyyy/MM */
	public static final String DATEFORMAT_STR_024 = "yyyy/MM";
	/** 格式 ：yyyy-MM-dd HH:mm:ss */
	public static final String DATEFORMAT_STR_025 = "yyyyMMddHHmmssSSS";

	/**
	 * 日期转换为字符串 格式自定义
	 * 
	 * @param date
	 * @param f
	 * @return
	 */
	public static String dateStr(Date date, String f) {
		SimpleDateFormat format = new SimpleDateFormat(f);
		if(date == null){
			return  "";
		}
		String str = format.format(date);
		return str;
	}
	
	/**
	 * yyyy-MM-dd HH:mm:ss
	 * 
	 * @param date
	 * @return
	 */
	public static String dateStr4(Date date) {
		return dateStr(date, DATEFORMAT_STR_001);

	}
	

	/**
	 * 前/后?天
	 * 
	 * @param d
	 * @param day
	 * @return
	 */
	public static Date rollDay(Date d, int day) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(d);
		cal.add(Calendar.DAY_OF_MONTH, day);
		return cal.getTime();
	}

	/**
	 * 前/后?月
	 * 
	 * @param d
	 * @param mon
	 * @return
	 */
	public static Date rollMon(Date d, int mon) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(d);
		cal.add(Calendar.MONTH, mon);
		return cal.getTime();
	}

	/**
	 * 前/后?年
	 * 
	 * @param d
	 * @param year
	 * @return
	 */
	public static Date rollYear(Date d, int year) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(d);
		cal.add(Calendar.YEAR, year);
		return cal.getTime();
	}

	public static Date rollDate(Date d, int year, int mon, int day) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(d);
		cal.add(Calendar.YEAR, year);
		cal.add(Calendar.MONTH, mon);
		cal.add(Calendar.DAY_OF_MONTH, day);
		return cal.getTime();
	}

	/**
	 * 获取当前时间-时间戳字符串
	 * 
	 * @return
	 */
	public static String getNowTimeStr() {
		String str = Long.toString(System.currentTimeMillis() / 1000);
		return str;
	}

	/**
	 * 比较两个日期大小,前者大返回true
	 *
	 * @param date1
	 * @param date2
	 * @return
	 */
	public static boolean dayCompare(Date date1, Date date2) {
		long time1 = date1.getTime();
		long time2 = date2.getTime();
		if (time1 - time2 >= 0) {
			return true;
		} else {
			return false;
		}
	}
   
	/**
	 * @Description: N日之后
	 * @param @param n
	 * @param @param date
	 * @param @return 设定文件
	 * @return Date 返回类型
	 * @throws
	 */
	public static Date nDayAfter(Integer n, Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.set(Calendar.DAY_OF_MONTH, cal.get(Calendar.DAY_OF_MONTH) + n);
		return cal.getTime();
	}

	/**
	 * 计算两个日期之间的小时 进方法之前要保证参数不为null
	 * @param beginDate 开始日期
	 * @param endDate  结束日期
	 * @return
	 */
	public static double betweenHourNumber(Date beginDate, Date endDate) {
		double diff = endDate.getTime() - beginDate.getTime();
		long nd = 1000 * 24 * 60 * 60;
		long nh = 1000 * 60 * 60;
		double hour = diff % nd / nh;
		return  hour;
	}

	/**
	 * 获取随机数字
	 * @param len
	 * @return
	 */
	public static String getRandomStr(int len){
		double d1 = Math.pow(10, len-1);
		double d2 = d1*Math.random()/2;
		long n = new Double(d1+d2).longValue();
		return String.valueOf(n);

	}
	
}
