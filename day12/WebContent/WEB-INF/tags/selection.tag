<%@ tag language="java" pageEncoding="UTF-8"%>

<%@ attribute name="border" %>
<%@ attribute name="bgcolor" %>

<jsp:useBean id="sel" class="day12.Selection" />

<h1><jsp:doBody /></h1>

<table border="${border}" bgcolor="${bgcolor}">
   <%
      for(String v:sel.getNamelist()){
         out.println("<tr><td>"+v+"</tr></td>");
      }
   %>
</table>