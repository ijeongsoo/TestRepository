<%-- 
    Document   : exam04_html_fragment
    Created on : 2017. 4. 27, 오후 3:22:02
    Author     : ijeongsu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%for (int i = 1; i <= 5; i++) {%>
<div>
  <img src="<%=application.getContextPath() %>/resources/images/member0<%=i%>.png" width="30px"/>
  <span>메시지<%=i%></span>
</div>
<%}%>