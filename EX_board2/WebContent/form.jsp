<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<form action="controller.jsp?action=insert" method="post">
		<table border="1">
			<tr>
				<td>제목</td>
				<td><input type="test" name="title"></td>
			</tr>
			<tr>
				<td>내용</td>
				<td><input type="test" name="content"></td>
			</tr>
			<tr>
				<td>작성자</td>
				<td><input type="test" name="wirter"></td>
			</tr>
			<tr>
				<td colspan="2" align="right"><input type="submit" value="글작성"></td>
			</tr>
		</table>
	</form>

</body>
</html>