<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.ArrayList"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1>선택한 상품 목록</h1>
<hr>
<%
   ArrayList<String> datas=(ArrayList)session.getAttribute("datas");
	if(datas==null){
		out.println("선택한 상품이 없습니다!");
	}else{
   out.println("<ol>");
   for(String v:datas){
      out.println("<li>"+v+"</li><br>");
   }
   out.println("</ol>");
}
%>


</body>
</html>