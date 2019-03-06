package com.manage.commom.utils;/**
 * Created by 59458 on 2017/6/15.
 */

/**
 * SeqNoUtils
 * Description 流水号util类
 * Copyrigth(C),2017,lx86468@126.com.com
 * Date 2017/6/15
 *
 * @author lixiao on 2017/6/15.
 * @version 1.0
 */
public class SeqNoUtils {

    /**
     * 获取6位以下随机数
     * @param min
     * @param max
     * @return
     */
    public static String getRandNum(int min, int max) {
        int randNum = min + (int)(Math.random() * ((max - min) + 1));
        return String.valueOf(randNum);
    }

    /**
     * 订单号生成
     * @param str
     * @return
     */
    public static String getSeqNo(String str){
        String randNum = getRandNum(1, 999999);
        while(randNum.length()<6){
            //不够6位左补0
            randNum="0"+randNum;
        }
        return str+DateUtil.getNowTimeStr()+randNum;
    }


    public static void main(String[] args) {
        for (int i = 0; i < 1000; i++) {
            System.out.println(getSeqNo("123"));
        }
    }
}