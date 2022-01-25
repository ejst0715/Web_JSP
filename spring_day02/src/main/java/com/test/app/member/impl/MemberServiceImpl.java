package com.test.app.member.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.app.board.BoardVO;
import com.test.app.board.impl.BoardDAO;
import com.test.app.member.MemberService;
import com.test.app.member.MemberVO;

@Service("memberService")
public class MemberServiceImpl implements MemberService	{
	@Autowired
	private MemberDAO memberDAO;
	@Autowired
	private BoardDAO boardDAO;
	/*
	 * public MemberDAO getMemberDAO() { return memberDAO; } public void
	 * setMemberDAO(MemberDAO memberDAO) { this.memberDAO = memberDAO; }
	 */

	@Override
	public MemberVO selectOne(MemberVO vo) {
		try {
			return memberDAO.selectOne(vo);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void insertMember(MemberVO vo) throws Exception{
		memberDAO.insertMemeber(vo);
		BoardVO board=new BoardVO();
		board.setWriter(vo.getName()+"님께서 첫번째 글을 작성하셨습니다.");
		boardDAO.insertBoard(board);
	}

}