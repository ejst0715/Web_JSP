<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	request.setCharacterEncoding("UTF-8");
	session.setAttribute("uid", request.getParameter("uid")); 
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%=session.getAttribute("uid") %>님, 환영합니다!<br>
<h1>상품 목록</h1>
<hr>
<form action="shop_add.jsp" method="post">
	<select name = "product">
			<option>수박</option>
			<option>멜론</option>
			<option>바나나</option>
			<option>사과</option>
			<option>포도</option>
	</select>
	<input type="submit" value="장바구니에 추가">
</form>
<hr>
<a href="shop_result.jsp">결제하기</a>

</body>
</html>