<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML>
<html>
<head>
<title>Stellar by HTML5 UP</title>
<meta charset="UTF-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, user-scalable=no" />
<link rel="stylesheet" href="assets/css/main.css" />
<noscript>
	<link rel="stylesheet" href="assets/css/noscript.css" />
</noscript>
</head>
<body class="is-preload">

	<!-- Wrapper -->
	<div id="wrapper">

		<!-- Main -->
		<div id="main">

			<!-- Introduction -->
			<section id="intro" class="main">
				<div class="spotlight">
					<div class="content">
						<header class="major">
							<h2>상세 페이지</h2>
						</header>
						<a href="main.do">메인 페이지로 이동하기</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="deleteBoard.do?bid=${data.bid}">글 삭제하기</a>
						<br>
						<form action="updateBoard.do" method="post">
							<input type="hidden" name="bid" value="${data.bid}">
							<table border="1">
								<tr>
									<td>글 제목</td>
									<td><input type="text" name="title" value="${data.title}"></td>
								</tr>
								<tr>
									<td>작성자</td>
									<td>${data.writer}</td>
								</tr>
								<tr>
									<td>글 내용</td>
									<td><input type="text" name="content"
										value="${data.content}"></td>
								</tr>
								<tr>
									<td>작성일</td>
									<td>${data.bdate}</td>
								</tr>
								<tr>
									<td>조회수</td>
									<td>${data.cnt}</td>
								</tr>
								<tr>
									<td colspan="2" align="right"><input type="submit" value="글 변경하기"></td>
								</tr>
							</table>
						</form>
					</div>
					<span class="image"><img alt="파일업로드 실습"
						src="${data.filepath}"></span>
				</div>
			</section>

		</div>

		<!-- Footer -->
		<footer id="footer">

			<p class="copyright">
				&copy; Untitled. Design: <a href="https://html5up.net">HTML5 UP</a>.
			</p>
		</footer>

	</div>

	<!-- Scripts -->
	<script src="assets/js/jquery.min.js"></script>
	<script src="assets/js/jquery.scrollex.min.js"></script>
	<script src="assets/js/jquery.scrolly.min.js"></script>
	<script src="assets/js/browser.min.js"></script>
	<script src="assets/js/breakpoints.min.js"></script>
	<script src="assets/js/util.js"></script>
	<script src="assets/js/main.js"></script>

</body>
</html>