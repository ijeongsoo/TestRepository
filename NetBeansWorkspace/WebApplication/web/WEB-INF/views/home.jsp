<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
  <head>
    <meta charset="UTF-8">
    <title>WebApplication</title>
  </head>
  
  <body>
    WebApplication Home
    <hr/>
    <h4>html 태그</h4>
    <a href="html/exam01">exam01</a>
    
    <h4>CSS</h4>
    <a href="css/exam01">exam01</a>
    <a href="css/exam02">exam02</a>
    <a href="css/exam03">exam03</a>
    
    <h4>Javascript</h4>
    <%for(int i=1; i<=11; i++){
	    String exam;
	    if(i<10) exam = "exam0"+i;
	    else exam = "exam"+String.valueOf(i);%>
	    <a href="javascript/<%=exam%>"><%=exam%></a>
    <%}%>
    
    <h4>Jquery</h4>
    <%for(int i=1; i<=4; i++){
	    String exam="exam";
	    exam+="0"+i;%>
	    <a href="jquery/<%=exam%>"><%=exam%></a>
    <%}%>
    
    <h4>BootStrap</h4>
    <%for(int i=1; i<=3; i++){
	    String exam="exam";
	    exam+="0"+i;%>
	    <a href="bootstrap/<%=exam%>"><%=exam%></a>
    <%}%>
  </body>
</html>