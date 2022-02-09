<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
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
							<h2><spring:message code="message.login.header" /></h2>
						</header>
						<form action="login.do" method="post">
							<table border="1">
								<tr>
									<td><spring:message code="message.login.table.id" /></td>
									<td><input type="text" name="mid" value="${user.mid}"></td>
								</tr>
								<tr>
									<td><spring:message code="message.login.table.pw" /></td>
									<td><input type="password" name="password"
										value="${user.password}"></td>
								</tr>
								<tr>
									<td colspan="2" align="right"><input type="submit"
										value="<spring:message code="message.login.table.login" />"></td>
								</tr>
							</table>
						</form>
						<hr>
						<a href="signin.do"><spring:message code="message.login.join" /></a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<a href="login.do?lang=en"><spring:message code="message.login.en" /></a>&nbsp;&nbsp;&nbsp;
						<a href="login.do?lang=ko"><spring:message code="message.login.ko" /></a>
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