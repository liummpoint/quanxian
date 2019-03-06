package com.manage.commom.utils;

public class FileUtil {
	
	/**
	 * 返回文件后缀的小写
	 * "" 文件格式不正确
	 * @param fileName
	 * @return
	 */
	public static String getFileSuffix(String fileName){
		
        int dot = fileName.lastIndexOf(".") ;
        if(dot == -1){
        	return "" ;
        }
        return  fileName.substring(dot+1).toLowerCase() ;
        
	}

}
