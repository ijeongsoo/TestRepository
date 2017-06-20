
<%@page contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page session="true"%>
<% if (session.getAttribute("login_info") != null) { %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, user-scalable=no">

<script type="text/javascript">
	function fileChange(event) {
		if ($("#battach")[0].files.length != 0) {
			$("#imgFileViewContainer").attr("hidden", false);
			$("#imgFileView")[0].src = URL
					.createObjectURL(event.target.files[0]);
			$("#imgFileView").attr("style", "height:250px");
			$("#battachBtn").text("사진 수정하기");

		}
	}
</script>

</head>
<body>
	<div class="modal-header">
		<button type="button" class="close" data-dismiss="modal"
			aria-label="Close">
			<span aria-hidden="true">&times;</span>
		</button>
		<h1 class="modal-title" id="myModalLabel">글쓰기</h1>
	</div>

	<div class="modal-body">
		<form action="write" method="post" enctype="multipart/form-data">
			<div class="alert alert-warning" role="alert">
				<span class="glyphicon glyphicon-exclamation-sign"
					aria-hidden="true"></span> <span class="sr-only">주의 :</span> 글내용을
				등록해 주세요
			</div>

			<div class="form-group">
				<div class="input-group">
					<span class="input-group-addon"> <span
						class="glyphicon glyphicon-user"></span>
					</span> <input type="text" class="form-control" placeholder="Title"
						name="btitle" required />
				</div>
			</div>
			<div class="form-group">
				<div class="input-group">
					<input type="hidden" class="form-control" name="bwriter"
						value="${sessionScope.login_info.mid}" />
				</div>
			</div>


			<div class="form-group">
				<div id="imgFileViewContainer" style="padding: 5px;" hidden="true"
					align="center">
					<img id="imgFileView" />
				</div>
				<div class="input-group col-lg-12 ">
					<label for="battach" id="battachBtn"
						class="col-lg-12 btn btn-default"><span
						class="glyphicon glyphicon-camera"></span> 사진 추가하기</label><input
						type="file" id="battach" style="visibility: hidden"
						onchange="fileChange(event)" name="battach" />
				</div>
			</div>



			<div class="form-group">
				<div class="input-group">
					<span class="input-group-addon"> <span
						class="glyphicon glyphicon-lock"></span>
					</span>
					<textarea rows="10" cols="30" class="form-control"
						placeholder="Content" name="bcontent"></textarea>
				</div>
			</div>





			<div class="alert alert-danger" role="alert">
				<span class="glyphicon glyphicon-exclamation-sign"
					aria-hidden="true"></span> <span class="sr-only">주의 :</span> 위 글내용을
				등록하시겠습니까?
			</div>


			<div class="modal-footer">
				<button type="button" class="btn btn-default" data-dismiss="modal">닫기</button>
				<button type="submit" class="btn btn-primary">글쓰기</button>
			</div>
		</form>
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
