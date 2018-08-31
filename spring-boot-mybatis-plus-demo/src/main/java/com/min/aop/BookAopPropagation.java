package com.min.aop;

import java.lang.reflect.Method;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

//@Aspect 
//@Service 
//@Component // 必须使用该注解
public class BookAopPropagation {
	
	// 切点
	@Pointcut("@annotation(org.springframework.transaction.annotation.Transactional)")
	public void transactionalAnnotation(){}
	
	/*
	 * 第一个*号表示的是返回值
	 * 包名表示要拦截的包名：com.min.service
	 * 第一个..：表示的是该包下的子包也作为要扫描的
	 * 第二个*号表示类名
	 * 第三个*号表示方法签名：任意的方法名
	 * 第二个..表示的任意参数
	 */
	@Pointcut("execution(* com.min.service..*.*(..)) && @annotation(org.springframework.transaction.annotation.Transactional)")
	public void scanBackage(){}
	
	// 前置通知
	@Before("scanBackage()")
	public void gettransactionalAnnotationInfo(JoinPoint point){
		Signature signature = point.getSignature();
		
		if (! (signature instanceof MethodSignature )) {
				try {
					throw new IllegalAccessException("该注解只能使用到方法上");
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				}
		}
		
		// 获取方法
		Class<?> clazz = point.getTarget().getClass();
		String methodName = signature.getName();
		Class<?>[] parameterTypes = ((MethodSignature)signature).getParameterTypes();
		Method method = null;
		try {
			method = clazz.getMethod(methodName, parameterTypes);
		} catch (NoSuchMethodException | SecurityException e) {
			e.printStackTrace();
		}
		
		if (method == null ) {
			return;
		}
		
		// 获取注解
		Transactional annotation = method.getAnnotation(Transactional.class);
		
		if (annotation == null) {
			return;
		}
		
		Propagation propagation = annotation.propagation();
		// 打印隔离级别
		System.out.println("current thread:"+Thread.currentThread().getName()+",隔离级别:"+propagation.value());
	}
	
	
	
}
