package com.test.app.board;

import java.util.List;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class BoardClient {

	public static void main(String[] args) {
		AbstractApplicationContext factory=new GenericXmlApplicationContext("applicationContext.xml");
		
		BoardService bs=(BoardService)factory.getBean("boardService");

		BoardVO vo=new BoardVO();
		
		vo.setContent("개인 포트폴리오3");
		vo.setTitle("귀멸의 칼날3");
		vo.setWriter("티모3");
		bs.insertBoard(vo); 

		List<BoardVO> datas=bs.selectAll(vo);
		for(BoardVO v:datas) {
			System.out.println(v);
		}
		
		factory.close();
	}

}
