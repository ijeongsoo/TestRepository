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



</head>
<body>
	
	<div class="modal-header">
		<button type="button" class="close" data-dismiss="modal"
			aria-label="Close">
			<span aria-hidden="true">&times;</span>
		</button>
		<h1 class="modal-title" id="myModalLabel">${member.mname} 정보</h1>
	</div>
	<div class="modal-body">
		<div class="alert alert-warning" role="alert">
			<span class="glyphicon glyphicon-exclamation-sign" aria-hidden="true"></span>
			<span class="sr-only">주의 :</span> 개인정보를 확인해 주세요.<br>
		</div>

		<div class="alert alert-success" role="alert">
			<h3>
				<label class="col-sm-3 control-label">ID</label> ${member.mid}
			</h3>


			<h3>
				<label class="col-sm-3 control-label">이름</label> ${member.mname}
			</h3>
			
			<h3>
				<label class="col-sm-3 control-label">Tel.</label> ${member.mtel}
			</h3>
			
			<h3>
				<label class="col-sm-3 control-label">주소</label> ${member.maddress}
			</h3>
			
			<h3>
				<label class="col-sm-3 control-label">E-mail</label> ${member.memail}
			</h3>
			
			<h3>
				<label class="col-sm-3 control-label">가입일</label> ${member.mdate}
			</h3>
			
			<div align="center">
			
				<img
					src="file?msavedfilename=${member.msavedfilename}&mfilecontent=${member.mfilecontent}"
					width="500px" />
			</div>
		</div>
		<div class="alert alert-danger" role="alert">
			<span class="glyphicon glyphicon-exclamation-sign" aria-hidden="true"></span>
			<span class="sr-only">주의 :</span> 개인정보의 유출에 주의해 주세요.<br> <span
				class="glyphicon glyphicon-exclamation-sign" aria-hidden="true"></span>
			<span class="sr-only">주의 :</span> 수정은 개인정보 수정을 클릭해 주세요.

		</div>
	</div>
	<div class="modal-footer">
		<button class="btn btn-primary" data-dismiss="modal">Close</button>
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