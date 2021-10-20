package com.douzone.mysite.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

@Aspect
@Component
public class MeasureExecutionTimeAspect {
	
	@Around("execution(* *..*.reposiory.*.*(..)) || execution(* *..*.service.*.*(..)) || execution(* *..*.controller.*.*(..))")
	public Object aroundAdvice(ProceedingJoinPoint pjp)throws Throwable {
		//before
		//실행 시간 측정 
		StopWatch sw = new StopWatch();
		sw.start();
		
		Object result = pjp.proceed();
		
		//after
		sw.stop();
		Long totalTime = sw.getTotalTimeMillis();

		//실행되는 클래스 이름
		String className = pjp.getTarget().getClass().getName();
		//실행되는 메소드 이름
		String methodName = pjp.getSignature().getName();
		
		String taskName = className+"."+methodName;
		
		System.out.println("[Excution Time]["+taskName+"] : "+totalTime+"-millis");
		
		return result;
	}
	
}
