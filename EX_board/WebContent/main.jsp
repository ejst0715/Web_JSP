<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.ArrayList,model.BoardVO" %>
<jsp:useBean id="datas"  class="java.util.ArrayList" scope="request"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메인 페이지</title>
</head>
<body>

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

<hr>

<a href="form.jsp">글 작성하기</a>

</body>
</html>