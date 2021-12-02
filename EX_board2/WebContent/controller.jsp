<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"  import="java.util.ArrayList, model.board.*"%>
<%
	request.setCharacterEncoding("UTF-8");
%>
<jsp:useBean id="dao" class="model.board.BoardDAO" />
<jsp:useBean id="vo" class="model.board.BoardVO" />
<jsp:setProperty property="*" name="vo" />
<%
		//사용자가 어떤 요청을 했는지에 따라,
		//비즈니스메서들르 수행시켜야함(DAO를 호출해야함)
		String action=request.getParameter("action");
%>
<%
	if (action.equals("main")) {
		ArrayList<BoardVO> datas = dao.selectAll();
		// 1. M에게서 데이터를 확보
		request.setAttribute("datas", datas);
		// 2. V한테 데이터를 전달
		pageContext.forward("main.jsp");
	} else if (action.equals("board")) {
		// 상세페이지보여줘!
		// 1. M에게서 데이터를 확보
		BoardVO data = dao.selectOne(vo);
		// 2. V한테 데이터를 전달
		request.setAttribute("data", data);
		pageContext.forward("board.jsp");
	} else if (action.equals("insert")) {
		if (dao.insert(vo)) {
			response.sendRedirect("controller.jsp?action=main");
		}
		throw new Exception("insert 수행중에 오류발생!");
	} else if (action.equals("delete")) {
		if (dao.delete(vo)) {
			response.sendRedirect("controller.jsp?action=main");
		}
		throw new Exception("delete 수행중에 오류발생!");
	} else if (action.equals("update")) {
		if (dao.update(vo)) { 
			response.sendRedirect("controller.jsp?action=main");
		}
		throw new Exception("update수행중에 오류발생!");
	} else {
		out.println("<script>alert('action파라미터의 값이 올바르지않습니다!')</script>");
	}
%>
