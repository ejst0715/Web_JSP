package com.test.app.board;

import java.util.List;

import com.test.app.board.impl.BoardDAO3;

public class BoardClient {

	public static void main(String[] args) {
		
		
		BoardDAO3 dao = new BoardDAO3();
		
		BoardVO vo = new BoardVO();
		
		vo.setContent("내용");
		vo.setTitle("제목");
		vo.setWriter("작성자");
		vo.setFilepath("abc");
		
		dao.insertBoard(vo);
		
		vo.setSearchContent(" ");
		List<BoardVO> datas=dao.selectAll(vo);
			for(BoardVO v: datas){
				System.out.println(v);
			}
	}

}
