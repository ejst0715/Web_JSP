<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
확인
<jsp:forward page="news.jsp">
		<jsp:param value="apple" name="a"/>
		<jsp:param value="bananal" name="b"/>
</jsp:forward>

</body>
</html>