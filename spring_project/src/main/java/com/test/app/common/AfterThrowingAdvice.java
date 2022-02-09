package com.test.app.common;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Service;

@Service
@Aspect
public class AfterThrowingAdvice {	
	@AfterThrowing(pointcut="PointcutCommon.aPointcut()",throwing="excep")
	public void exceptionLog(JoinPoint jp,Exception excep) { // 諛붿씤�뱶 蹂��닔
		String coreMethod=jp.getSignature().getName();
		System.out.println("ATA "+coreMethod+"() �닔�뻾以묒뿉 臾몄젣,�삁�쇅 諛쒖깮�떆 異쒕젰");
		System.out.println("�삁�쇅硫붿꽭吏�: "+excep.getMessage());
		
		if(excep instanceof IllegalArgumentException) {
			System.out.println("�궗�슜�븯吏��븡�뒗 留ㅺ컻蹂��닔�엯�땲�떎.");
		}
		else if(excep instanceof NullPointerException) {
			System.out.println("媛앹껜�깮�꽦 �떎�뙣�뻽�뒿�땲�떎.");
		}
		else {
			System.out.println("�쁽�옱 �삁�쇅�뒗 �뙆�븙�릺吏��븡�� �삁�쇅�엯�땲�떎! 遺꾩꽍�씠 �븘�슂�빀�땲�떎!");
		}
	}
}
