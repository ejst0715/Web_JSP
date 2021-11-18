<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.ArrayList"%>
    <%
    	request.setCharacterEncoding("UTF-8");
    	String product=request.getParameter("product");
    	
    	ArrayList<String> datas= (ArrayList)session.getAttribute("datas");
    	
    	if(session.getAttribute("datas")==null){	
    		//장바구니가 매번생성되는것xxxx
    		//처음 장바구니에 상품을 추가할때만 1회 생성됨
    	datas = new ArrayList<String>();
    	session.setAttribute("datas", datas);
    	}
    	
    	datas.add(product);
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<script type="text/javascript">
		alert("<%=product%>가 장바구니에 추가 되었습니다!");
		history.go(-1);
	</script>

</body>
</html>