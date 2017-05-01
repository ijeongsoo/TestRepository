<%-- 
    Document   : exam02_include
    Created on : 2017. 4. 28, 오전 11:42:56
    Author     : ijeongsu
--%>

<%@page import="java.util.Calendar"%>
<%@page contentType="text/html; charset=UTF-8" %>
<%
	    Calendar now = Calendar.getInstance();
	    int year=now.get(Calendar.YEAR);
	    int month=now.get(Calendar.MONTH)+1;  
	    int date=now.get(Calendar.DAY_OF_MONTH);
	    
    %>
    <%=year%>년 <%=month%>월 <%=date%>