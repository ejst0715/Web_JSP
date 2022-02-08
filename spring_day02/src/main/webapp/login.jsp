<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="login.do" method="post">
	<table border="1">
		<tr>
			<td>아이디</td>
			<td><input type="text" name="mid" value="${user.mid}"></td>
		</tr>
		<tr>
			<td>비밀번호</td>
			<td><input type="password" name="password" value="${user.password}"></td>
		</tr>
		<tr>
			<td colspan="2" align="right"><input type="submit" value="로그인하기"></td>
		</tr>
	</table>
</form>
<hr>
<a href="signin.do">회원가입</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<a href="login.do?lang=en">영어로</a>&nbsp;&nbsp;&nbsp;
<a href="login.do?lang=ko">한국어로</a>

</body>
</html>