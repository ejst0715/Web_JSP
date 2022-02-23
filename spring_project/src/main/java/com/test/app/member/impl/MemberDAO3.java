package com.test.app.member.impl;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.test.app.member.MemberVO;

@Repository("memberDAO")
public class MemberDAO3 {
	
	@Autowired
	private SqlSessionTemplate mybatis;
	
	public void updateMember(MemberVO vo) {
		mybatis.update("MemberDAO.updateMember", vo);
	}
	public void insertMember(MemberVO vo) {
		mybatis.insert("MemberDAO.insertMember", vo);
	}
	public MemberVO selectOne(MemberVO vo){
		return (MemberVO) mybatis.selectOne("MemberDAO.selectOne", vo);
	}
}

