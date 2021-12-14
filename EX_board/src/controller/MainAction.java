package controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.BoardDAO;
import model.BoardVO;

public class MainAction implements Action{

   @Override
   public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
            
      BoardDAO dao=new BoardDAO();
      
      ArrayList<BoardVO> datas=dao.selectAll();
      request.setAttribute("datas", datas);
      
      ActionForward forward=new ActionForward();
      forward.setPath("main.jsp");
      forward.setRedirect(false);
      
      return forward;
   }

}