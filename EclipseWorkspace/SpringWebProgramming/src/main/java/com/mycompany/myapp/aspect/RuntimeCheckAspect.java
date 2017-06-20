package com.mycompany.myapp.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class RuntimeCheckAspect {
	private static final Logger LOGGER = LoggerFactory.getLogger(RuntimeCheckAspect.class);
	
	//Point Cut
	@Pointcut("execution(public * com.mycompany.myapp.controller.Exam12DBController.*(..))" )
	private void runtimeCheck(){
		
	}
	
	//Advice
	@Around("runtimeCheck()")
	public Object runtimeCheckAdvice(ProceedingJoinPoint joinPoint) throws Throwable{
		//before code
		long startTime = System.nanoTime();
		
		//실제 메소드 호출 
		Object result=joinPoint.proceed();
		
		
		//after code
		long endTime= System.nanoTime();
		
		long time=endTime-startTime;
		String realMethod = joinPoint.getSignature().toShortString();
		
		LOGGER.info(realMethod+" 실행 시간 : "+time+"ns");
		return result;
		
		
	}
}
