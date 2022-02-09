package com.test.app.board;

import java.util.List;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class BoardClient {

	public static void main(String[] args) {
		AbstractApplicationContext factory=new GenericXmlApplicationContext("applicationContext.xml");
		
		BoardService bs=(BoardService)factory.getBean("boardService");
		// 寃뚯떆湲� �옉�꽦�븯湲� 踰꾪듉�쓣 �늻由�
		// 寃뚯떆湲� �옉�꽦 �럹�씠吏�
		// 寃뚯떆湲��쓣 �옉�꽦�븿
		// 湲� �벑濡� 踰꾪듉�쓣 �늻由�
		BoardVO vo=new BoardVO();
		///vo.setBid(8); // 8o  8xxx
		vo.setContent("개인 포트폴리오3");
		vo.setTitle("귀멸의 칼날3");
		vo.setWriter("티모3");
		bs.insertBoard(vo); // c媛� insert 鍮꾩쫰�땲�뒪硫붿꽌�뱶瑜� �닔�뻾
		// -> �떎吏덉쟻�쑝濡쒕뒗 dao媛� �빐�떦 濡쒖쭅�쓣 �닔�뻾�븿
		
		// �쟾泥대ぉ濡앸낫湲� �럹�씠吏�
		List<BoardVO> datas=bs.selectAll(vo);
		for(BoardVO v:datas) {
			System.out.println(v);
		}
		
		factory.close();
	}

}
