package com.manage.datasourceAnnotation;

public class DynamicDataSourceHolder {
	
	private static final ThreadLocal<SourcesEnum> THREAD_LOCAL = new ThreadLocal<>();
	
	public static void putDataSource(SourcesEnum dbType){
		THREAD_LOCAL.set(dbType);
	}
	
	public static SourcesEnum getDataSource(){
		return THREAD_LOCAL.get() ;
	}
	
	public static void removeDataSource(){
		THREAD_LOCAL.remove();
	}

}
