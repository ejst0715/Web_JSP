<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:useBean id="calc" class="calc.CalcBean"/>
<jsp:setProperty property="*" name="calc"/>

<% 
	calc.work();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title></head>
<body>
	<form method="post">
		<input type="text" name="num1"> <select name="op">
			<option selected>+</option>
			<option>-</option>
		</select> <input type="text" name="num2"> <input type="submit"
			value="계산하기">
	</form>
		<hr>
		<%=calc.getRes()%>
</body>
</html>