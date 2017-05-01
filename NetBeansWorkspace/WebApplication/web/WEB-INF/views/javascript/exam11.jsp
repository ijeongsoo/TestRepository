<%-- 
    Document   : exam11
    Created on : 2017. 4. 27, 오전 11:53:41
    Author     : ijeongsu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no">
    <title>JSP Page</title>
    <link href="/WebApplication/resources/bootstrap-3.3.7/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
    <script src="/WebApplication/resources/jquery/jquery-3.2.1.min.js" type="text/javascript"></script>
    <script src="/WebApplication/resources/bootstrap-3.3.7/js/bootstrap.min.js" type="text/javascript"></script>
    <script>
	function handleBtn1(){
	  //var img=document.querySelector("img");
	  //img.src="/WebApplication/resources/images/photo02.jpg";
	  var imgArr=document.querySelectorAll("img");
	  for(var i=0; i<imgArr.length; i++){
	    imgArr[i].src="/WebApplication/resources/images/photo02.jpg";
	  }
    
	}
	function handleBtn2(){
	  var img1=document.querySelector("#img1");
	  img1.src="/WebApplication/resources/images/photo03.jpg";
	}
	function handleBtn3(){
	  var img1=document.querySelectorAll(".class1");
	  for(var i=0; i<img1.length; i++){
	    img1[i].src="/WebApplication/resources/images/photo04.jpg";
	  }
	}
    </script>
  </head>
  <body>
    <h1>DOM 사용하기</h1>
    <div>
	<button onClick="handleBtn1()">이미지 변경</button><br/>
	<img src="/WebApplication/resources/images/photo01.jpg" width="100px"/>
	<img src="/WebApplication/resources/images/photo01.jpg" width="100px"/>
    </div>
    <div>
	<button onClick="handleBtn2()">img1이미지 변경</button>
	<button onClick="handleBtn3()">class1이미지 변경</button><br/>
	<img id="img1" src="/WebApplication/resources/images/photo01.jpg" width="100px"/>
	<img class="class1" src="/WebApplication/resources/images/photo01.jpg" width="100px"/>
	<img class="class1" src="/WebApplication/resources/images/photo01.jpg" width="100px"/>
    </div>
    
  </body>
</html>
