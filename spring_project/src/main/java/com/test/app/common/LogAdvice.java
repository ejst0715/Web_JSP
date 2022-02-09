package com.test.app.common;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;

@Service // 1. @ �뒪罹붾쾾�쐞�뿉 異붽�
@Aspect // 4. �븷�뒪�뙥�듃 �꽕�젙 -> �떎�떆媛� �쐞鍮숈쿂由�
public class LogAdvice {
	
	// 2. �룷�씤�듃而� �꽕�젙
	@Pointcut("execution(* com.test.app..*Impl.select*(..))")
	public void bPointcut() {}
	
	// JP: �뒪�봽留� 而⑦뀒�씠�꼫媛� new JP() (==jp媛앹껜�깮�꽦)
	// �쁽�옱 �닔�뻾�릺�뒗 鍮꾩쫰�땲�뒪硫붿꽌�뱶 �젙蹂대�� �뀑�똿!
	
	// 3. �뼱�뱶諛붿씠�뒪 �꽕�젙 + �룞�옉�떆�젏
	@Before("bPointcut()")
	public void printLog(JoinPoint jp) {
		System.out.println("B 동작시점 횡단관심수행중...");
		String coreMethod=jp.getSignature().getName(); // 硫붿꽌�뱶 �떆洹몃땲爾�
		System.out.println("泥섎━以묒씤 鍮꾩쫰�땲�뒪 硫붿꽌�뱶紐�: "+coreMethod);
		Object[] args=jp.getArgs();
		System.out.println("args�뱾: ");
		for(Object v:args) {
			System.out.print(v+" ");
		}
		System.out.println();
	}
}
