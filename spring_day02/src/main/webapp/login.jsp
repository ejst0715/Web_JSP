<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<form action="login.do" method="post">
	<table border="1">
		<tr>
			<td>���̵�</td>
			<td><input type="text" name="mid" value="${user.mid}"></td>
		</tr>
		<tr>
			<td>��й�ȣ</td>
			<td><input type="password" name="password" value="${user.password}"></td>
		</tr>
		<tr>
			<td colspan="2" align="right"><input type="submit" value="�α����ϱ�"></td>
		</tr>
	</table>
</form>
</body>
</html>