package com.test.app.board;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.test.app.board.impl.BoardDAO;

@Controller
public class BoardController {

	@RequestMapping("/board.do")
	public String board(BoardVO vo,BoardDAO dao,Model model) {
		System.out.println("로그: board() @컨트롤러");
		model.addAttribute("data", dao.selectOne(vo));
		return "board.jsp";
	}
	@RequestMapping(value="/insertBoard.do")
	public String insertBoard(BoardVO vo,BoardDAO dao) {
		System.out.println("로그: insertBoard() @컨트롤러");
		dao.insertBoard(vo);
		return "main.do";
	}
	@RequestMapping("/main.do")
	public String main(BoardVO vo,BoardDAO dao,Model model) {
		System.out.println("로그: main() @컨트롤러");
		model.addAttribute("datas",dao.selectAll(vo));
		return "main.jsp";
	}
	@RequestMapping("/updateBoard.do")
	public String updateBoard(BoardVO vo,BoardDAO dao) {
		System.out.println("로그: updateBoard() @컨트롤러");
		dao.updateBoard(vo);
		return "main.do";
	}
	@RequestMapping("/deleteBoard.do")
	public String deleteBoard(BoardVO vo,BoardDAO dao) {
		System.out.println("로그: deleteBoard() @컨트롤러");
		dao.deleteBoard(vo);
		return "main.do";
	}
}
