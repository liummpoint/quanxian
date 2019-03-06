package com.manage.datasourceAnnotation;

import java.lang.reflect.Method;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(1)
@EnableAspectJAutoProxy(proxyTargetClass=true)
public class DataSourceAspect {
	 private static final Logger logger = LoggerFactory.getLogger(DataSourceAspect.class);
	@Pointcut("execution(* com.manage.service.*.*(..))")
	public void dataSourcePointCut(){
		
	}
	
	@Before("dataSourcePointCut()")
	public void before(JoinPoint joinPoint){
		Object target = joinPoint.getTarget() ;
		String method = joinPoint.getSignature().getName() ;
		Class<?>[] clazz = target.getClass().getInterfaces() ;
		Class<?>[] parameterTypes = ((MethodSignature) joinPoint.getSignature()).getMethod().getParameterTypes();
		try{
			Method m = clazz[0].getMethod(method, parameterTypes) ;
			if(m != null && m.isAnnotationPresent(TargetDataSource.class)){
				TargetDataSource data = m.getAnnotation(TargetDataSource.class) ;
				SourcesEnum dataSourceName = data.value() ;
				DynamicDataSourceHolder.putDataSource(dataSourceName);
				logger.debug("current thread " + Thread.currentThread().getName() + " add " + dataSourceName + " to ThreadLocal");
			}else{
				logger.debug("switch datasource fail , use default");
			}
		}catch(Exception e){
			logger.error("current thread " + Thread.currentThread().getName() + " add data to ThreadLocal error" , e);
		}
		
		
	}
	
	@After("dataSourcePointCut()")
	public void after(JoinPoint joinPoint){
		DynamicDataSourceHolder.removeDataSource(); 
	}
	
}
