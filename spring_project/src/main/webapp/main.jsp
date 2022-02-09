<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
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
							<h2>
								<spring:message code="message.header.title" />
							</h2>
							<h5>${memData.name}<spring:message
									code="message.header.hello" />
							</h5>
							<a href="logout.do"><spring:message
									code="message.header.logout" /></a>
						</header>
						<table>
							<tr>
								<th><spring:message code="message.body.table.num" /></th>
								<th><spring:message code="message.body.table.title" /></th>
								<th><spring:message code="message.body.table.writer" /></th>
								<th><spring:message code="message.body.table.reg" /></th>
								<th><spring:message code="message.body.table.cnt" /></th>
							</tr>
							<c:forEach var="v" items="${datas}">
								<tr>
									<td><a href="board.do?bid=${v.bid}">${v.bid}</a></td>
									<td>${v.title}</td>
									<td>${v.writer}</td>
									<td>${v.bdate}</td>
									<td>${v.cnt}</td>
								</tr>
							</c:forEach>
						</table>
						<hr>
						<a href="insertBoard.jsp"><spring:message
								code="message.footer.board" /></a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a
							href="mypage.do"><spring:message code="message.footer.member" /></a>
					</div>
					<span class="image"><img src="images/pic01.jpg" alt="" /></span>
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