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
		<h1 class="modal-title" id="myModalLabel">${board.btitle}</h1>
	</div>
	<div class="modal-body">
		<div class="alert alert-warning" role="alert">
			<div class="col-md-5">
				<span class="glyphicon glyphicon-exclamation-sign"
					aria-hidden="true"></span> <span class="sr-only"></span><b>글쓴이</b>
				: ${board.bwriter}
			</div>
			<div class="col-md-5">
				<span class="glyphicon glyphicon-exclamation-sign"
					aria-hidden="true"></span> <span class="sr-only"></span><b>글쓴
					날짜</b> : ${board.bdate}
			</div>
			<div>
				<span class="glyphicon glyphicon-exclamation-sign"
					aria-hidden="true"></span> <span class="sr-only"></span><b>조회수</b>
				: ${board.bhitcount}
			</div>
		</div>


		<div class="alert alert-success" role="alert">
			<div align="center">
				<img
					src="file?bsavedfilename=${board.bsavedfilename}&bfilecontent=${board.bfilecontent}"
					width="500px" />
			</div>
			<hr>
			<div style="padding: 20px">
				<h4>${board.bcontent }</h4>
			</div>

		</div>
		<div class="alert alert-info" role="alert">
			<h3 align="center">
				파일 다운로드 :<a
					href="file?bsavedfilename=${board.bsavedfilename}&bfilecontent=${board.bfilecontent}">
					<span class="glyphicon glyphicon-floppy-save" aria-hidden="true"></span>
					<span class="sr-only"></span>${board.boriginalfilename }</a>
			</h3>
		</div>
	</div>

	<div class="modal-footer">
		<button class="btn btn-primary" data-dismiss="modal">Close</button>
		<c:if test="${sessionScope.login_info.mid eq board.bwriter}">
			<a type="button" class="btn btn-success"
				href="update?bno=${board.bno}" data-toggle="modal"
				data-target="#update" onclick="closeModal()">수정</a>
			<a type="button" class="btn btn-danger"
				href="delete?bno=${board.bno}">삭제</a>
		</c:if>
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