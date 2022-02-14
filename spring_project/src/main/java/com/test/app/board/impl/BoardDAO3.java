package com.test.app.board.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.test.app.board.BoardVO;
import com.test.app.board.SqlSessionFactoryBean;

public class BoardDAO3 {
	private SqlSession mybatis;
	public BoardDAO3() {
		mybatis = SqlSessionFactoryBean.getSqlSessionInstance();
	}
	
	public void insertBoard(BoardVO vo) {
		mybatis.insert("BoardDAO.insertBoard" , vo);
		mybatis.commit();
	}
	public void updateBoard(BoardVO vo) {
		mybatis.update("BoardDAO.updateBoard" , vo);
		mybatis.commit();
	}
	public void deleteBoard(BoardVO vo) {
		mybatis.insert("BoardDAO.deleteBoard" , vo);
		mybatis.commit();
	}
	public List<BoardVO> selectAll(BoardVO vo) {
		return mybatis.selectList("BoardDAO.selectAll", vo);
	}
	public BoardVO selectOne(BoardVO vo) {
		return mybatis.selectOne("BoardDAO.selectOne", vo);
	}
}
