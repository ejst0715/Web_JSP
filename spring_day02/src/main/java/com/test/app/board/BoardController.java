package com.test.app.board;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("data")
public class BoardController {

	@Autowired
	BoardService bs;
	
	// @RequestMapping보다 먼저 호출되는 @MA
	@ModelAttribute("conditionMap")
	public Map<String,String> searchConditionMap(){
		Map<String,String> conditionMap = new HashMap<String,String>();
		conditionMap.put("제목", "title");
		conditionMap.put("작성자", "writer");
		return conditionMap;
	}
	
	@RequestMapping("/board.do")
	public String board(BoardVO vo,Model model) {
		System.out.println("로그: board() @컨트롤러");
		model.addAttribute("data", bs.selectOne(vo));
		return "board.jsp";
	}
	@RequestMapping(value="/insertBoard.do")
	public String insertBoard(BoardVO vo) {
		System.out.println("로그: insertBoard() @컨트롤러");
		bs.insertBoard(vo);
		return "main.do";
	}
	@RequestMapping("/main.do")
	public String main(BoardVO vo,Model model) {
		// @을 활용하여 인자로 검색을 다뤘었음
		// @RequestParam(value="searchCondition",defaultValue="title",required=false)String searchCondition,@RequestParam(value="searchContent",defaultValue="",required=false)String searchContent
		System.out.println("조건: "+vo.getSearchCondition());
		System.out.println("내용: "+vo.getSearchContent());
		if(vo.getSearchCondition()==null) {
			vo.setSearchCondition("title");
		}
		if(vo.getSearchContent()==null) {
			vo.setSearchContent("");
		}
		model.addAttribute("datas",bs.selectAll(vo));
		// @MA설정이 추가되면서, model객체에 Map,AL 두개의 컬렉션이 저장되어있음!
		return "main.jsp";
	}
	@RequestMapping("/updateBoard.do")
	public String updateBoard(@ModelAttribute("data")BoardVO vo) {
		System.out.println("로그: updateBoard() @컨트롤러" + vo);
		System.out.println("작성자정보: "+vo.getWriter());
		/// 49번라인에서, data라는 이름의 @MA설정을 추가했기때문에, @SA->null 방지 처리 진행함!
		bs.updateBoard(vo);
		return "main.do";
	}
	@RequestMapping("/deleteBoard.do")
	public String deleteBoard(BoardVO vo) {
		System.out.println("로그: deleteBoard() @컨트롤러");
		bs.deleteBoard(vo);
		return "main.do";
	}
}
