package com.test.app.member;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("memData")
public class LoginController {

	@Autowired
	MemberService ms;
	
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
	public String login(MemberVO vo,Model model) {
		if(vo.getMid()==null || vo.getMid().equals("")) {
			throw new IllegalArgumentException("아이디를 입력하지않았습니다!");
		}
		System.out.println("로그: login() @컨트롤러 "+vo);
		MemberVO data=ms.selectOne(vo);
		if(data!=null) {
			///session.setAttribute("userName", data.getName());
			model.addAttribute("memData", data); // 마이페이지에서 이용할 데이터
			return "main.do";
		}
		return "login.jsp";
	}
	@RequestMapping("/logout.do")
	public String logout(HttpSession session) {
		System.out.println("로그: logout() @컨트롤러");
		session.invalidate();
		return "index.jsp";
	}
	@RequestMapping(value="/signin.do",method=RequestMethod.GET)
	public String signin() {
		System.out.println("GET signin.do");
		return "signin.jsp";
	}
	@RequestMapping(value="/signin.do",method=RequestMethod.POST)
	public String signin(MemberVO vo) {
		System.out.println("로그: signin() @컨트롤러 "+vo); ///////
		ms.insertMember(vo);
		return "login.jsp";
	}
	@RequestMapping(value="/mypage.do",method=RequestMethod.GET)
	public String mypage(@ModelAttribute("memData")MemberVO vo,Model model) {
		System.out.println("GET mypage.do "+vo);
		model.addAttribute("mem",ms.selectOne(vo));
		return "mypage.jsp";
	}
	@RequestMapping(value="/mypage.do",method=RequestMethod.POST)
	public String mypage(@ModelAttribute("memData")MemberVO vo) {
		System.out.println("로그: mypage() @컨트롤러 "+vo); ///////
		ms.updateMember(vo);	
		return "main.do";
	}
}
