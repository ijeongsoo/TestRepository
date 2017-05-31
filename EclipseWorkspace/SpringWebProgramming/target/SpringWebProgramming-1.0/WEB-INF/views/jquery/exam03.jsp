<%-- 
    Document   : exam02
    Created on : 2017. 4. 27, 오후 2:13:53
    Author     : ijeongsu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no">
    <title>JSP Page</title>
    <link href="<%=application.getContextPath() %>/resources/bootstrap-3.3.7/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
    <script src="<%=application.getContextPath() %>/resources/jquery/jquery-3.2.1.min.js" type="text/javascript"></script>
    <script src="<%=application.getContextPath() %>/resources/bootstrap-3.3.7/js/bootstrap.min.js" type="text/javascript"></script>
    <script>
	function changDivContent(){
	  $("#div1").html("<p>변경된 내용</p>");
	  $("#div2").append("<p>변경된 내용</p>");
	}
	
	function changCSS(){
	  $("#div3").css("background-color", "#ffff00");
	  $("#div3").css("width", "300px");
	}
	
	
	
    </script>
  </head>
  <body>
    <h1>DOM내용 변경</h1>
    
    <h3>DIV 내용변경</h3>
    <a href="javascript:changDivContent()">변경</a>
    <div id="div1">
	<img class="class1" src="<%=application.getContextPath() %>/resources/images/photo01.jpg" width="100px"/>
    </div>
    
    <div id="div2">
	<img class="class1" src="<%=application.getContextPath() %>/resources/images/photo01.jpg" width="100px"/>
    </div>
    
    <h3>CSS 변경</h3>
    <a href="javascript:changCSS()">변경</a>
    <div id="div3" style="border: 1px solid black; width: 100px; height: 100px;">
    </div>
    
    
  </body>
</html>
