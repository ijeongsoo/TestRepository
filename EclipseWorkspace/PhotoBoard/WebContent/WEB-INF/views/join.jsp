<%@page contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

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

<script type="text/javascript">
	function fileChange(event) {
		if ($("#mattach")[0].files.length != 0) {
			var originalfilename = $("#mattach")[0].files[0].name;
			$("#imgFileView")[0].src = URL
					.createObjectURL(event.target.files[0]);
			$("#imgFileView").attr("style", "height:100px");
			$("#mattachBtn").text("수정");
			$("#imgcheck").removeClass("alert-danger");
			$("#imgcheck").addClass("alert-info");
			$("#imgcheck").text('프로필사진이 선택되었습니다.');
		}
	}
</script>
<script>
	$(function() {
		$("#mPasswordCheck").keyup(
				function() {
					if ($("#mPasswordCheck").val() == ''
							|| $("#mpassword").val() == '') {
						$("#pwcheck").removeClass("alert-danger");
						$("#pwcheck").removeClass("alert-info");
						$("#pwcheck").text('비밀번호를 한번 더 입력해주세요.');
					} else if ($("#mPasswordCheck").val() == $("#mpassword")
							.val()) {
						if (($("#mPasswordCheck").val() == $("#mpassword")
								.val())
								&& ($("#mPasswordCheck").val() == ' ' || $(
										"#mpassword").val() == ' ')) {
							$("#pwcheck").removeClass("alert-danger");
							$("#pwcheck").removeClass("alert-info");
							$("#pwcheck").text('비밀번호를 한번 더 입력해주세요.');
						} else {
							$("#pwcheck").removeClass("alert-danger");
							$("#pwcheck").removeClass("alert-info");
							$("#pwcheck").addClass("alert-info");
							$("#pwcheck").text('비밀번호가 일치합니다.');
						}

					} else {
						$("#pwcheck").addClass("alert-danger");
						$("#pwcheck").text('비밀번호가 일치하지 않습니다.');
					}
				});

		$("#mpassword").keyup(
				function() {
					if ($("#mPasswordCheck").val() == ''
							|| $("#mpassword").val() == '') {
						$("#pwcheck").removeClass("alert-danger");
						$("#pwcheck").removeClass("alert-info");
						$("#pwcheck").text('비밀번호를 한번 더 입력해주세요.');
					} else if ($("#mPasswordCheck").val() == $("#mpassword")
							.val()) {
						if (($("#mPasswordCheck").val() == $("#mpassword")
								.val())
								&& ($("#mPasswordCheck").val() == ' ' || $(
										"#mpassword").val() == ' ')) {
							$("#pwcheck").removeClass("alert-danger");
							$("#pwcheck").removeClass("alert-info");
							$("#pwcheck").text('비밀번호를 한번 더 입력해주세요.');
						} else {
							$("#pwcheck").removeClass("alert-danger");
							$("#pwcheck").addClass("alert-info");
							$("#pwcheck").text('비밀번호가 일치합니다.');
						}
					} else {
						$("#pwcheck").addClass("alert-danger");
						$("#pwcheck").text('비밀번호가 일치하지 않습니다.');
					}

				});

	});

	$(document).ready(function() {
		$("#mid").keyup(function() {
			$("#canUse").removeClass("alert-danger");
			$("#canUse").removeClass("alert-warning");
			$("#canUse").removeClass("alert-info");
			$("#canUse").text('중복확인해주세요');

		});

		$("#checkButton").click(function() {
			if ($("#mid").val() == "") {
				$("#canUse").addClass("alert-danger");
				$("#canUse").text('ID를 입력해주세요.');
			} else {
				$.ajax({
					'url' : "check_id",
					'data' : {
						'mid' : $("#mid").val()
					},
					'type' : "POST",
					'success' : function(data) {
						if (data.result == 1) {
							alert('사용 가능한 아이디 입니다.');
							$("#canUse").removeClass("alert-danger");
							$("#canUse").removeClass("alert-warning");
							$("#canUse").addClass("alert-info");
							$("#canUse").text('중복확인 되었습니다.');

						} else if (data.result == 0) {
							alert('사용 불가능한 아이디 입니다. ');
							$("#canUse").removeClass("alert-info");
							$("#canUse").removeClass("alert-warning");
							$("#canUse").addClass("alert-danger");
							$("#canUse").text('다시 입력해주세요');
						} else {
							alert('아이디를 입력해 주세요 ');
							$("#canUse").removeClass("alert-info");
							$("#canUse").removeClass("alert-danger");
							$("#canUse").addClass("alert-warning");
							$("#canUse").text('아이디를 입력해주세요.');
						}

					}
				});
			}

		});
	});
</script>


<script>
	function check() {
		if ($("#canUse").text() != "중복확인 되었습니다.") {
			alert('중복확인 해주시기 바랍니다.');
			return false;
		} else if ($("#pwcheck").text() != "비밀번호가 일치합니다.") {
			alert('비밀번호불일치');
			return false;
		} else if (!($("#agree").is(":checked"))) {
			alert('이용약관에 동의해주세요');
			$("#agree").focus();
			return false;
		} else if ($("#imgcheck").text() != "프로필사진이 선택되었습니다.") {
			$("#imgcheck").addClass("alert-danger");
			alert('프로필사진이 선택되지 않았습니다.');
			return false;
		} else {
			alert('회원가입이 완료되었습니다.');
			return true;
		}
	}
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
				<a class="navbar-brand" style="color: #ffffff;" href="index.php">PhotoBoard</a>
				<ul class="nav navbar-nav">
					<li><a href="http://www.sw.org/">한국소프트웨어산업협</a></li>
					<li><a href="http://computer.seoultech.ac.kr/">IoT전문가양성과</a></li>
					<li><a href="About.html">About</a></li>
				</ul>
			</div>

		</div>
	</nav>

	<div class="container">
		<div class="jumbotron row col-lg-12 ">

			<h2>회원가입전 주의사항을 확인해주세요</h2>
			<p class="lead">Cras justo odio, dapibus ac facilisis in, egestas
				eget quam. Fusce dapibus, tellus ac cursus commodo, tortor mauris
				condimentum nibh, ut fermentum massa justo sit amet risus.</p>
			<p>
				<a class="btn btn-lg btn-success" href="Agree.html" role="button">이용약관</a>
			</p>
			<div class="form-group">

				<label> <input id="agree" type="checkbox" required>
					이용약관에 동의합니다.
				</label>
			</div>
		</div>
	</div>
	</div>
	<hr>
	</br>
	<div class="contentwrap">
		<article class="container">

			<form id="formjoin" class="form-horizontal" name="member_form"
				method="POST" enctype="multipart/form-data"
				onsubmit="return check()">
				<div class="form-group">
					<label class="col-sm-3 control-label" for="inputEmail">ID</label>
					<div class="col-sm-5">
						<input class="form-control" name="mid" id="mid" type="text"
							placeholder="ID" required> <label id="canUse"
							class="help-block">중복확인해주세요</label>
					</div>
					<a id="checkButton" class="btn btn-default">중복확인</a>

				</div>

				<div class="form-group">
					<label class="col-sm-3 control-label" for="inputPassword">비밀번호</label>
					<div class="col-sm-6">
						<input class="form-control" id="mpassword" name="mpassword"
							type="password" placeholder="비밀번호" required>
					</div>
				</div>
				<div class="form-group">
					<label class="col-sm-3 control-label" for="inputPasswordCheck">비밀번호
						확인</label>
					<div class="col-sm-6">
						<input class="form-control" id="mPasswordCheck"
							name="mPasswordCheck" type="password" placeholder="비밀번호 확인"
							required> <label id="pwcheck" name="pwcheck"
							class="help-block">비밀번호를 한번 더 입력해주세요.</label>
					</div>
				</div>
				<div class="form-group">
					<label class="col-sm-3 control-label" for="inputAddress">주소</label>
					<div class="col-sm-6">
						<input class="form-control" id="maddress" name="maddress"
							type="text" placeholder="주소" required>
					</div>
				</div>
				<div class="form-group">
					<label class="col-sm-3 control-label" for="inputName">이름</label>
					<div class="col-sm-6">
						<input class="form-control" id="mname" name="mname" type="text"
							placeholder="이름" required>
					</div>
				</div>
				<div class="form-group">
					<label class="col-sm-3 control-label" for="inputNumber">휴대폰번호</label>
					<div class="col-sm-4">
						<input class="form-control" id="mtell" name="mtell" type="text"
							placeholder="휴대폰번호" required> <label class="help-block">-
							없이 적어주세요.</label>
					</div>
				</div>
				<div class="form-group">
					<label class="col-sm-3 control-label" for="email">이메일</label>
					<div class="col-sm-6">
						<input class="form-control" id="memail" name="memail" type="text"
							placeholder="E-mail" required>
					</div>

				</div>
				<div class="form-group">
					<label class="col-sm-3 control-label" for="inputNumberCheck">프로필
						사진등록</label>
					<div class="col-sm-6">
						<div>
							<img id="imgFileView" /> <label for="mattach" id="mattachBtn"
								class="btn btn-default">등록</label> <input type="file"
								id="mattach" style="visibility: hidden"
								onchange="fileChange(event)" name="mattach" /><label
								class="help-block" id="imgcheck" name="imgcheck">사진을 반드시
								첨부해 주세요.</label>
						</div>
					</div>
				</div>

				</br>
				<div class="form-group">
					<label class="col-sm-3 control-label"></label>
					<div class="col-sm-6">
						<button id="join" name="join" class="btn btn-primary col-sm-12"
							type="submit">회원가입</button>
					</div>
				</div>
			</form>
		</article>
	</div>
	<hr>
	</br>
	<footer>
		<p align="center">
			&copy; DB_Lap 2015</br> H.P. : 010-9895-5986</br> 서울특별시 노원구 공릉로 232 </br>서울과학기술대학교
			미래관 306호
		</p>
	</footer>

</body>


</html>