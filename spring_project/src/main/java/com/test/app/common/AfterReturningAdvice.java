package com.test.app.common;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Service;

import com.test.app.board.BoardVO;
import com.test.app.member.MemberVO;

@Service
@Aspect
public class AfterReturningAdvice {
		
	@AfterReturning(pointcut="PointcutCommon.bPointcut()",returning="obj")
	public void afterLog(JoinPoint jp,Object obj) { // "諛붿씤�뱶 蹂��닔"�쁿
		String coreMethod=jp.getSignature().getName();
		System.out.println("AR어드바이스 "+coreMethod+"()");
		if(obj instanceof MemberVO) {
			MemberVO vo=(MemberVO)obj; // �떎�슫 罹먯뒪�똿
			System.out.println("MemberVO를 반환 "+vo);
		}
		else if(obj instanceof BoardVO) {
			BoardVO vo=(BoardVO)obj;
			System.out.println("BoardVO를 반환 "+vo);
		}
		else {
			System.out.println("일치하는 객체없음!");
		}
	}
}
