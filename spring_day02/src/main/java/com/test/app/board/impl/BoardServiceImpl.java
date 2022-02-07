package com.test.app.board.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.app.board.BoardService;
import com.test.app.board.BoardVO;

@Service("boardService")
public class BoardServiceImpl implements BoardService{
	
	@Autowired
	private BoardDAO2 boardDAO;
		
	@Override
	public void insertBoard(BoardVO vo) {
		if(vo.getWriter().equals("젠이츠")) {
			throw new IllegalArgumentException("문제발생?");
		}
		boardDAO.insertBoard(vo);
		///boardDAO.insertBoard(vo); // 트랜잭션 실습중 -> rollback();
	}

	@Override
	public void updateBoard(BoardVO vo) {
		boardDAO.updateBoard(vo);
	}

	@Override
	public void deleteBoard(BoardVO vo) {
		boardDAO.deleteBoard(vo);
	}

	@Override
	public BoardVO selectOne(BoardVO vo) {
		return boardDAO.selectOne(vo);
	}

	@Override
	public List<BoardVO> selectAll(BoardVO vo) {
		System.out.println("검색로직추가함!");
		return boardDAO.selectAll(vo);
	}

}
