package com.test.app.member;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.test.app.member.impl.MemberDAO;

public class MemberClient {
	public static void main(String[] args) {
		AbstractApplicationContext factory=new GenericXmlApplicationContext("applicationContext.xml");
		
		MemberService ms=(MemberService)factory.getBean("memberService");
			
		// 濡쒓렇�씤 �솕硫댁뿉�꽌 ID,PW瑜� �엯�젰�븯怨� 濡쒓렇�씤 踰꾪듉�쓣 �늻由�
		MemberVO vo=new MemberVO();
		vo.setMid("kim");
		vo.setPassword("1234");
		
		MemberVO data=ms.selectOne(vo);
		if(data==null) {
			System.out.println("로그인실패!");
		}
		else {
			System.out.println(" ["+data.getRole()+"]"+data.getName()+"로그인성공! :D");
		}
	
		
		vo.setMid("test");
		vo.setName("젠이츠");
		vo.setPassword("4321");
		vo.setRole("USER");
		try {
			ms.insertMember(vo);
		} catch (Exception e) {
			System.out.println("에러페이지");
		}
		
		
		factory.close();
	}
}
