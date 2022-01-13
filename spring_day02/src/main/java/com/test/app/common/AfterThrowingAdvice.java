package com.test.app.common;

import org.aspectj.lang.JoinPoint;

public class AfterThrowingAdvice {
	public void exceptionLog(JoinPoint jp, Exception excep) { 	//바인드 변수
		String coreMethod = jp.getSignature().getName();
		System.out.println("비즈니스 메서드 " + coreMethod+"()수행중에 문제,예외 발생시 출력");
		System.out.println("예외메세지: " + excep.getMessage());
		
		if(excep instanceof IllegalArgumentException) {
			System.out.println("사용하지 않는 매게변수입니다.");
		}else if(excep instanceof NullPointerException) {
			System.out.println("객체생성 실패");
		}else {
			System.out.println("파악되지않은 예외");
		}
	}
}
