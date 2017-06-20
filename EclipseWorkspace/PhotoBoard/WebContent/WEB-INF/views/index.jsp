<%@page contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%
	if (session.getAttribute("login_info") == null) {
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, user-scalable=no">
<title>PhotoBoard</title>
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
	$(document).ready(function(){
			if (${result} == 0) {
				alert('로그인에 실패하였습니다.');
			}
	});
		
</script>

</head>
<body>
	<nav class="navbar navbar-inverse">
		<div class="container">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed"
					data-toggle="collapse" data-target="#navbar" aria-expanded="false"
					aria-controls="navbar">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" style="color: #ffffff;" href="/PhotoBoard/">PhotoBoard</a>
				<ul class="nav navbar-nav">
					<li><a href="http://www.sw.org/">한국소프트웨어산업협</a></li>
					<li><a href="#">IoT전문가양성과</a></li>
					<li><a href="About.html">About</a></li>
				</ul>
			</div>

		</div>
	</nav>

	<div class="container">
		</br>
		<div class="row row-offcanvas row-offcanvas-right">

			<div class="col-xs-12 col-sm-6">
				<p class="pull-right visible-xs">
					<button type="button" class="btn btn-primary btn-xs"
						data-toggle="offcanvas">Toggle nav</button>
				</p>
				<div class="jumbotron">
					<h1>Hello!</h1>
					<h1>PhotoBoard World!</h1>
					<p>This is an example to show the homwork of an IoT Engineer
						Training Course in Korea Software Industry Oranization. This board
						can upload the photo and view thoes.</p>
				</div>
				<div class="row">
					<div class="col-xs-6 col-lg-7">
						<p>
							<a class="btn btn-default" href="#" role="button">View
								details &raquo;</a>
						</p>
					</div>
					<!--/.col-xs-6.col-lg-4-->

				</div>
				<!--/row-->
			</div>
			<!--/.col-xs-12.col-sm-9-->

			<div class="col-xs-6 col-sm-6 sidebar-offcanvas" id="sidebar">
				<div class="col-xs-6 col-sm-11">
					<form id="formLogin" class="form-signin" method="post">

						<h2 class="form-signin-heading">Please sign in</h2>
						<label for="inputEmail" class="sr-only">ID</label> <input
							type="text" name="mid" id="mid" class="form-control"
							placeholder="ID" required autofocus> <label
							for="inputPassword" class="sr-only">Password</label> <input
							type="password" name="mpassword" id="mpassword"
							class="form-control" placeholder="Password" required>
						<div class="checkbox">
							<label> <input id="idSaveCheck" type="checkbox"
								value="remember-me"> Remember me
							</label>
						</div>
						<label></label>
						<button class="btn btn-lg btn-primary btn-block" type="submit">로그인</button>
						<a class="btn btn-lg btn-primary btn-block" href="join">회원가입</a> <label></label>
						<div class="alert alert-warning" role="alert">
							<a class="alert-link">Notice 가입관련 문의는 아래 내용을 참고해주세요.</br>문의전화 :
								010-9895-5986</br>E-mail : dlwjdtn890@naver.com
							</a>
						</div>

					</form>

				</div>
				<!-- /container -->

			</div>
			<!--/.sidebar-offcanvas-->
		</div>
		<!--/row-->
		</br>
		<div id="carousel-example-generic" class="carousel slide"
			data-ride="carousel">
			<!-- Indicators -->
			<ol class="carousel-indicators">
				<li data-target="#carousel-example-generic" data-slide-to="0"
					class="active"></li>
				<li data-target="#carousel-example-generic" data-slide-to="1"></li>
				<li data-target="#carousel-example-generic" data-slide-to="2"></li>
			</ol>

			<!-- Wrapper for slides -->
			<div class="carousel-inner" role="listbox">
				<div class="item active">
					<img src="resources/images/p.png" alt="First slide">
					<div class="carousel-caption">
						<div class="container">
							<div class="carousel-caption">
								<h1>Another example headline.</h1>
								<p>Cras justo odio, dapibus ac facilisis in, egestas eget
									quam. Donec id elit non mi porta gravida at eget metus. Nullam
									id dolor id nibh ultricies vehicula ut id elit.</p>

							</div>
						</div>
					</div>
				</div>
				<div class="item">
					<img src="resources/images/p.png" alt="Second slide">
					<div class="carousel-caption">
						<div class="container">
							<div class="carousel-caption">
								<h1>Another example headline.</h1>
								<p>Cras justo odio, dapibus ac facilisis in, egestas eget
									quam. Donec id elit non mi porta gravida at eget metus. Nullam
									id dolor id nibh ultricies vehicula ut id elit.</p>

							</div>
						</div>
					</div>
				</div>
				<div class="item">
					<img src="resources/images/p.png" alt="Second slide">
					<div class="carousel-caption">
						<div class="container">
							<div class="carousel-caption">
								<h1>Another example headline.</h1>
								<p>Cras justo odio, dapibus ac facilisis in, egestas eget
									quam. Donec id elit non mi porta gravida at eget metus. Nullam
									id dolor id nibh ultricies vehicula ut id elit.</p>

							</div>
						</div>
					</div>
				</div>
			</div>

			<!-- Controls -->
			<a class="left carousel-control" href="#carousel-example-generic"
				role="button" data-slide="prev"> <span
				class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
				<span class="sr-only">Previous</span>
			</a> <a class="right carousel-control" href="#carousel-example-generic"
				role="button" data-slide="next"> <span
				class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
				<span class="sr-only">Next</span>
			</a>
		</div>


		<hr>
		<footer class="footer">
			<div class="container">
				<p class="text-muted">&copy; JS Corporation 2017</p>
			</div>
		</footer>


	</div>
</body>
</html>
<%
	} else {
%>
<script>
location.href='main';
</script>

<%
	}
%>