<%@page contentType="text/html; charset=UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page session="true" %>
<% if (session.getAttribute("login_info") != null) { %>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no">
    <title>JSP Page</title>
    <link href="<%=application.getContextPath() %>/resources/bootstrap-3.3.7/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
    <script src="<%=application.getContextPath() %>/resources/jquery/jquery-3.2.1.min.js" type="text/javascript"></script>
    <script src="<%=application.getContextPath() %>/resources/bootstrap-3.3.7/js/bootstrap.min.js" type="text/javascript"></script>

<style type="text/css"> #navbar .active a{color: #337ab7; background-color: #e4e4e4;}</style>
<style type="text/css"> #navbar a:hover{color: #337ab7; background-color: #eee;}</style>
<style type="text/css"> #navbar .active a:hover{color: #337ab7; background-color: #e4e4e4;}</style>
<style type="text/css"> #navbar a{border-radius:0px;}</style>
<style type="text/css"> #jumbotron {background-color: #e4e4e4; border-radius:0px;}</style>
  </head>
	<body>
		<nav class="navbar navbar-inverse">
		<div class="container">
			<a class="navbar-brand" style="color: #ffffff;" href="/PhotoBoard/">PhotoBoard</a>
			<ul id="navbar1" class="nav navbar-nav">
				<li><a href="http://www.sw.org/">한국소프트웨어산업협</a></li>
					<li><a href="#">IoT전문가양성과</a></li>
					<li><a href="About.html">About</a></li>
				<li style="margin-left: 500px;" class="dropdown"><a
					style="color: #ffffff;" href="#" data-toggle="dropdown">Welcome,
						${sessionScope.login_info.mname} <b class="caret"></b>
				</a>
					<ul class="dropdown-menu">
						<li><a href="memberDetail?mid=${sessionScope.login_info.mid}" data-toggle="modal" data-target="#myInfo"><i
								class="glyphicon glyphicon-cog"></i> 내정보</a></li>
						<li><a href="admin_editInfo.html"><i
								class="glyphicon glyphicon-edit"></i> 내정보 수정</a></li>
						<li class="divider"></li>
						<li><a href="logout"><i class="glyphicon glyphicon-off"></i>
								로그아웃</a></li>
					</ul>
			</ul>

		</div>
	</nav>
	
	<div class="modal fade" id="myInfo" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true"
			style="overflow: auto;">
		<div class="modal-dialog" >
			<div class="modal-content">
				
			</div>
		</div>
	</div>
	

	<div class="container">

      <div class="masthead">
       
        <nav>
          <ul id="navbar" class="nav nav-pills nav-justified">
            <li class="active"><a href="main.html">Home</a></li>
            <li><a href="board">Board</a></li>
            
          </ul>
        </nav>
      </div>
     <div id="jumbotron" class="jumbotron">
        <h1>Welcome to the DB_Lab!</h1> <p><a class="btn btn-lg btn-success" href="#" role="button">Get started today</a></p>
       </div>
   
      <hr>

      <footer>
        <p  align="center">&copy; DB_Lap 2015</br>
		H.P. : 010-9895-5986</br>
		서울특별시 노원구 공릉로 232 </br>서울과학기술대학교 미래관 306호
		</p>
      </footer>

    </div>
	</body>
</html>

<%
	} else {
%>
<script>
location.href='/PhotoBoard/';
</script>

<%
	}
%>