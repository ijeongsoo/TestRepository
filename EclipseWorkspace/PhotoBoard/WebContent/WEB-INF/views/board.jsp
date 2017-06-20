<%@page contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page session="true"%>
<%
	if (session.getAttribute("login_info") != null) {
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, user-scalable=no">
<title>JSP Page</title>
<link
	href="<%=application.getContextPath()%>/resources/bootstrap-3.3.7/css/bootstrap.min.css"
	rel="stylesheet" type="text/css" />
<script
	src="<%=application.getContextPath()%>/resources/jquery/jquery-3.2.1.min.js"
	type="text/javascript"></script>
<script
	src="<%=application.getContextPath()%>/resources/bootstrap-3.3.7/js/bootstrap.min.js"
	type="text/javascript"></script>


<script>
	$(document).ready(function() {
		$('#view').on('hidden.bs.modal', function() {
			$(this).removeData('bs.modal');
			$("#viewModalContent").empty();
		});
	});
</script>

<script>
	

		$('#view').on('hidden.bs.modal', function() {
			$(this).removeData('bs.modal');
		});
	
</script>

<style type="text/css">
#navbar .active a {
	color: #337ab7;
	background-color: #e4e4e4;
}
</style>
<style type="text/css">
#navbar a:hover {
	color: #337ab7;
	background-color: #eee;
}
</style>
<style type="text/css">
#navbar .active a:hover {
	color: #337ab7;
	background-color: #e4e4e4;
}
</style>
<style type="text/css">
#navbar a {
	border-radius: 0px;
}
</style>
<style type="text/css">
#jumbotron {
	background-color: #e4e4e4;
	border-radius: 0px;
}
</style>
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
					<li><a href="main">Home</a></li>
					<li class="active"><a href="board">Board</a></li>

				</ul>
			</nav>
		</div>

		<div id="jumbotron" class="jumbotron">
			<h1>Welcome to the PhotoBoard!</h1>
			<h2>사진 게시판에 오신걸 환영합니다.</h2>
			<p>
				<button type="button" class="btn btn-lg btn-success"
					data-toggle="modal" data-target="#about_join">About
					Manage_Student</button>
			</p>


			<div class="modal fade" id="about_join" tabindex="-1" role="dialog"
				aria-labelledby="myModalLabel">
				<div class="modal-dialog" role="document">
					<div class="modal-content">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal"
								aria-label="Close">
								<span aria-hidden="true">&times;</span>
							</button>
							<h4 class="modal-title" id="myModalLabel">About
								Manage_Student</h4>
						</div>
						<div class="modal-body">머긴머야 학생관리지</div>
						<div class="modal-footer">
							<button type="button" class="btn btn-primary"
								data-dismiss="modal">Close</button>
						</div>
					</div>
				</div>
			</div>
		</div>



		<div class="alert alert-success" role="alert">
			<form action="manage_student.html" method="get">
				<div class="col-md-3">
					<font size=7>게시물 검색</font>
				</div>
				<div class="col-md-1">
					<select style="font-size: 45px" name="searchColumn">
						<option></option>
						<option></option>
						<option></option>
					</select>
				</div>

				<div class="input-group col-md-6">

					<input type="text" name="searchText" value=""
						style="height: 64px; margin-left: 40px; font-size: 40px"
						class="form-control"> <span class="input-group-btn">
						<button class="btn btn-success" type="submit"
							style="font-size: 35px; margin-left: 41px">검색</button>
					</span>
				</div>
				<!-- /input-group -->
			</form>
		</div>
		<br>



		<div class="col-md-12">
			<c:forEach var="b" items="${list}">
				<div class="col-md-3" align="center" style="padding: 30px">
					<a data-toggle="modal" data-target="#view"
						href="boardDetail?bno=${b.bno}"><img
						src="file?bsavedfilename=${b.bsavedfilename}&bfilecontent=${b.bfilecontent}"
						height="150px" /></a>
					<div style="padding: 10px">
						<table width="180" style="table-layout: fixed">
							<tr>
								<td
									style="width: 10px; white-space: nowrap; text-align: center; vertical-align: middle; text-overflow: ellipsis; overflow: hidden;"><span
									class="glyphicon glyphicon-camera"></span> ${b.btitle}</td>
							</tr>
							<tr>
								<td
									style="width: 10px; white-space: nowrap; text-align: center; vertical-align: middle; text-overflow: ellipsis; overflow: hidden;"><span
									class="glyphicon glyphicon-pencil"></span> ${b.bwriter}</td>
							</tr>
						</table>
					</div>
				</div>
			</c:forEach>
		</div>



		<div style="margin-top: 20px; text-align: center">
			<a href="board?pageNo=1">[처음]</a>
			<c:if test="${groupNo>1}">
				<a href="board?pageNo=${startPageNo-1}">[이전]</a>
			</c:if>
			<c:forEach var="i" begin="${startPageNo }" end="${endPageNo }">
	 &nbsp;
	 <a href="board?pageNo=${i}"
					<c:if test="${pageNo==i}">style="font-weight: bold; color:red"</c:if>>${i}</a>
	 &nbsp; 
	 </c:forEach>
			<c:if test="${groupNo<totalGroupNo}">
				<a href="board?pageNo=${endPageNo+1}">[다음]</a>
			</c:if>
			<a href="board?pageNo=${totalPageNo}">[맨끝]</a>
		</div>



		<div class="modal fade" id="view" tabindex="-1" role="dialog"
			aria-labelledby="myModalLabel" aria-hidden="true"
			style="overflow: auto;">
			<div class="modal-dialog modal-lg">
				<div class="modal-content" id="viewModalContent"></div>
			</div>
		</div>



		<div class="modal fade" id="write" tabindex="-1" role="dialog"
			aria-labelledby="myModalLabel" aria-hidden="true"
			style="overflow: auto;">
			<div class="modal-dialog modal-lg">
				<div class="modal-content"></div>
			</div>
		</div>

		<div class="modal fade" id="update" tabindex="-1" role="dialog"
			aria-labelledby="myModalLabel" aria-hidden="true"
			style="overflow: auto;">
			<div class="modal-dialog modal-lg">
				<div class="modal-content"></div>
			</div>
		</div>



		<div class="col-md-11"></div>

		<div class="btnSet">
			<div style="margin-top: 20px; text-align: right">
				<a type="button" class="btn btn-success" href="write"
					data-toggle="modal" data-target="#write">글쓰기</a>
			</div>
		</div>


	</div>




	<!--<p><a class="btn btn-lg btn-success" href="#" role="button" ><font size = 300 ><br>학생<br>회원 가입<br><br></font></a></p>-->
	<hr>

	<footer>
		<p align="center">
			&copy; DB_Lap 2015</br> H.P. : 010-9895-5986</br> 서울특별시 노원구 공릉로 232 </br>서울과학기술대학교
			미래관 306호
		</p>
	</footer>
</body>
</html>

<%
	} else {
%>
<script>
	location.href = '/PhotoBoard/';
</script>

<%
	}
%>