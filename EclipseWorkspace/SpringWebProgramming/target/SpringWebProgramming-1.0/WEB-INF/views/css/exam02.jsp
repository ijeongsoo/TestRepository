<%-- 
    Document   : exam02
    Created on : 2017. 4. 26, 오전 9:10:50
    Author     : ijeongsu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8">
    <title>JSP Page</title>
    <style type="text/css">
	/*태그 선택자*/
	div{
	  background-color: yellow; border: 1px solid black;height: 100px;
	}
	
	.skyblue{
	  background-color: skyblue;
	}
	.btn{
	  border: 1px solid black;height: 70px; padding: 5px; 
	}
	.success{background-color: forestgreen; color:white;}
	.warning{background-color: red; color: white;}
	#goldDiv1{background-color: gold;}
	#goldDiv2{background-color: goldenrod;}
    </style>
  </head>
  <body>
    
    <div >div태그</div>
    <div >div태그</div>
    <div >div태그</div>
    <div class="skyblue">div 태그</div>
    <div class="skyblue">div 태그</div>
    <div id="goldDiv1" class="skyblue">div 태그</div>
    <div id="goldDiv2" class="skyblue">div 태그</div>
    <a class="btn success">확인</a>
    <a class="btn warning">확인</a>


    
    
  </body>
</html>
