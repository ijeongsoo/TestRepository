<%-- 
    Document   : html
    Created on : 2017. 4. 25, 오후 12:11:57
    Author     : ijeongsu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSP Page</title>
    <script>
	function handleBtnNaber(){
	  
	    console.log("handleBtnNaber()...");
	    location.href = "http://www.naver.com";
	}
	function handleBtnGoogle(){
	    console.log("handleBtnNaber()...");
	  location.href = "http://www.google.com";
	}
    </script>
  </head>
  <body>
    <h1>태그 종류</h1>
    
    <h3>링크 태그</h3>
    <a href="http://www.naver.com"> 네이버</a>
    
    
    <h3>버튼 태그</h3>
    <button id="btnNaver" onclick="handleBtnNaber()">네이버 </button>
    <button id="btnGoogle" onclick="handleBtnGoogle()">구글 </button>
    
    <h3>이미지 태그</h3>
    
    <h3>폼 태그</h3>
    이름: <input type="text" /></br>
    나이: <input type="number" /></br>
    생년월일 :<input type="date" /></br>
    성별 :<input type="radio" name="sex"/>남<input type="radio" name="sex"/>여</br>
    관심분야 :<input type="checkbox" />자바
    <input type="checkbox" />자바FX
    <input type="checkbox" />스프링</br>
    <input type="button" value ="aaa"/>
    

  </body>
</html>
