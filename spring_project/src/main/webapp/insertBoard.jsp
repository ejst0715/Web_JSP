<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML>
<html>
<head>
<title>Stellar by HTML5 UP</title>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="assets/css/main.css" />
<style>
.dellink {
   display: none;
}
</style>
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
                     <h2>글 작성 페이지</h2>
                  </header>
                  <a href="main.do">메인 페이지로 이동하기</a> <br>
                  <form action="insertBoard.do" method="post"
                     enctype="multipart/form-data">
                     <table border="1">
                        <tr>
                           <td>글 제목</td>
                           <td><input type="text" name="title"></td>
                        </tr>
                        <tr>
                           <td>작성자</td>
                           <td><input type="text" name="writer"></td>
                        </tr>
                        <tr>
                           <td>글 내용</td>
                           <td><input type="text" name="content"></td>
                        </tr>
                        <tr>
                           <td>파일업로드</td>
                           <td><input type="file" class="hidden_input"
                              id="imageSelector" name="file"
                              accept="image/jpeg, image/jpg, image/png" multiple /></td>
                        </tr>
                        <tr>
                           <td colspan="2"><input type="submit" value="글 등록하기"></td>
                        </tr>
                     </table>
                  </form>
               </div>
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