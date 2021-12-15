package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.board.BoardDAO;
import model.board.BoardVO;
import model.board.ReplyVO;

public class insertRaction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
	
	
		ReplyVO rvo = new ReplyVO();
		
		rvo.setBid(Integer.parseInt(request.getParameter("bid")));
		rvo.setMid(request.getParameter("mid"));
		rvo.setRmsg(request.getParameter("msg"));
		
		BoardDAO dao = new BoardDAO();
		dao.insertR(rvo);
		
		ActionForward forward = new ActionForward();
		forward.setPath("main.do");
		forward.setRedirect(false);
		
		return forward;
	
	}
	
}
