package com.test.app.common;

import org.aspectj.lang.ProceedingJoinPoint;

public class AroundAdvice {
	
	// pjp=new PJP("현재 실행하는 비즈니스 메서드 정보");
	
	public Object aroundLog(ProceedingJoinPoint pjp) throws Throwable {
		System.out.println("[비즈니스 메서드 수행전]");
		
		Object obj=pjp.proceed(); // 비즈니스 메서드를 탈취
		
		System.out.println("[비즈니스 메서드 수행후]");
		
		return obj;
	}
}
