package com.test.app.member.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.app.member.MemberService;
import com.test.app.member.MemberVO;

@Service("memberService")
public class MemberServiceimpl implements MemberService	{
	@Autowired
	private MemberDAO memberDAO;
	
	
	
	public MemberDAO getMemberDAO() {
		return memberDAO;
	}



	public void setMemberDAO(MemberDAO memberDAO) {
		this.memberDAO = memberDAO;
	}



	@Override
	public MemberVO selectOne(MemberVO vo) {
		return memberDAO.selectOne(vo);
	}

}
// 1. applicationContext.xml에서 setter로 DI(의존성 주입)
// 2. @ 변경