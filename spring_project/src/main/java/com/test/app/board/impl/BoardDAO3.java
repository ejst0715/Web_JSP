package com.test.app.board.impl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.test.app.board.BoardVO;

// 1. 상속
// 2. @
@Repository("boardDAO")
public class BoardDAO3 {

	@Autowired
	private SqlSessionTemplate mybatis;

	public void insertBoard(BoardVO vo) {
		mybatis.insert("BoardDAO.insertBoard", vo);
	}

	public void updateBoard(BoardVO vo) {
		mybatis.update("BoardDAO.updateBoard", vo);
	}

	public void deleteBoard(BoardVO vo) {
		mybatis.delete("BoardDAO.deleteBoard", vo);
	}

	public List<BoardVO> selectAll(BoardVO vo) {
		return mybatis.selectList("BoardDAO.selectAll", vo);
		/*if (vo.getSearchCondition().equals("title")) {
			return mybatis.selectList("BoardDAO.selectT", vo);
		}
		return mybatis.selectList("BoardDAO.selectW", vo);*/
	}

	public BoardVO selectOne(BoardVO vo) {
		return (BoardVO) mybatis.selectOne("BoardDAO.selectOne", vo);
	}

}