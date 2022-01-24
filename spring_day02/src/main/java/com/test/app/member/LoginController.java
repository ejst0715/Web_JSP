package com.test.app.member;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.test.app.member.impl.MemberDAO;

@Controller
public class LoginController {

	// 오버로딩 vs 오버라이딩
	// 함수명 중복정의 허용 vs 메서드 재정의
	@RequestMapping(value="/login.do",method=RequestMethod.GET)
	public String showLogin(@ModelAttribute("user")MemberVO vo) {
		System.out.println("로그: 요청방식 실습_GET");
		vo.setMid("bang");
		vo.setPassword("1234");
		return "login.jsp";
	}
	@RequestMapping(value="/login.do",method=RequestMethod.POST)
	public String login(MemberVO vo,MemberDAO dao,HttpSession session) {
		System.out.println("로그: login() @컨트롤러");
		MemberVO data=dao.selectOne(vo);
		if(data!=null) {
			session.setAttribute("userName", data.getName());
			return "main.do";
		}
		return "index.jsp";
	}
	@RequestMapping("/logout.do")
	public String logout(HttpSession session) {
		System.out.println("로그: logout() @컨트롤러");
		session.invalidate();
		return "index.jsp";
	}
}
