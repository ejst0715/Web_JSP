<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.ArrayList,model.BoardVO" %>
<jsp:useBean id="datas" scope="request" class="java.util.ArrayList" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메인 페이지</title>
<link rel="stylesheet" href="css/style.css" type ="text/css"/>
</head>
<body>

<%
      //System.out.println("datas상태: "+datas);
      //System.out.println("datas의 크기: "+datas.size());
      if(datas.size()==0){
         %>
         <img alt="티모 이모티콘" src="image/timo.jpg">
         <%
      }
      else{
%>
<table border="1">
   <tr>
      <th>글 번호</th><th>글 제목</th><th>작성자</th>
   </tr>
   <%
      for(BoardVO v:(ArrayList<BoardVO>)datas){
   %>   
   <tr>
      <td><a href="controller.jsp?action=board&bid=<%=v.getBid()%>"><%=v.getBid()%></a></td><td><%=v.getTitle()%></td><td><%=v.getWriter()%></td>
   </tr>
   <%
      }
   %>
</table>
<%
   }
%>

<hr>

<a href="form.jsp">글 작성하기</a>

</body>
</html>