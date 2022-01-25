<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>마이페이지</h1>
<a href="main.do">메인 페이지로 이동하기</a>
<hr>
<form action="mypage.do" method="post">
	<table border="1">
		<tr>
			<td>아이디</td>
			<td>${mem.mid}</td>
		</tr>
		<tr>
			<td>비밀번호</td>
			<td><input type="password" name="password" value="${mem.password}"></td>
		</tr>
		<tr>
			<td>이름</td>
			<td><input type="text" name="name" value="${mem.name}"></td>
		</tr>
		<tr>
			<td>등급</td>
			<td>${mem.role}</td>
		</tr>
		<tr>
			<td colspan="2" align="right"><input type="submit" value="회원정보변경하기"></td>
		</tr>
	</table>
</form>
</body>
</html>