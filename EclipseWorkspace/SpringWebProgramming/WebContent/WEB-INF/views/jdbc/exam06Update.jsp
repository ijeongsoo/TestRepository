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
			$("#spanFileName").text(originalfilename);
		}
	}
</script>
</head>
<body>
	<h4>Modify Member</h4>
	<form method="post" enctype="multipart/form-data">
		<input type="hidden" name="mid" value="${member.mid}" />
		<div class="form-group">
			<div class="input-group">
				<span class="input-group-addon"> <span
					class="glyphicon glyphicon-user"></span>
				</span> <input type="text" class="form-control" placeholder="Name"
					name="mname" value="${member.mname}" />
			</div>
		</div>

		<div class="form-group">
			<div class="input-group">
				<span class="input-group-addon"> <span
					class="glyphicon glyphicon-lock"></span>
				</span> <input type="password" class="form-control" placeholder="Password"
					name="mpasswd" value="${member.mpasswd}" />
			</div>
		</div>
		<div class="form-group">
			<div class="input-group">
				<span class="input-group-addon"> <span
					class="glyphicon glyphicon-tag"></span>
				</span> <input type="text" class="form-control" placeholder="Tel"
					name="mtel" value="${member.mtel}" />
			</div>
		</div>

		<div class="form-group">
			<div class="input-group">
				<span class="input-group-addon"> <span
					class="glyphicon glyphicon-lock"></span>
				</span> <input type="text" class="form-control" placeholder="E-mail"
					name="memail" value="${member.memail}" />
			</div>
		</div>

		<div class="form-group">
			<div class="input-group">
				<span class="input-group-addon"> <span
					class="glyphicon glyphicon-lock"></span>
				</span> <input type="text" class="form-control" placeholder="Age"
					name="mage" value="${member.mage}" />
			</div>
		</div>

		<div class="form-group">
			<div class="input-group">
				<span class="input-group-addon"> <span
					class="glyphicon glyphicon-lock"></span>
				</span> <input type="text" class="form-control" placeholder="Address"
					name="maddress" value="${member.maddress}" />
			</div>
		</div>



		<div class="form-group">
			<div class="input-group" style="height: 150px;">
				<span class="input-group-addon"> <span
					class="glyphicon glyphicon-camera"></span>
				</span>
				<div class="form-control" style="height: 150px;">
					<img id="imgFileView"
						src="file/exam01?msavedfilename=${member.msavedfilename}"
						width="100px" /> <span id="spanFileName">${member.moriginalfilename}</span>
					<label for="mattach" class="btn btn-default">변경</label> <input
						type="file" id="mattach" style="visibility: hidden"
						onchange="fileChange(event)" name="mattach" />
				</div>
			</div>
		</div>

		<input type="submit" class="btn btn-info" value="Modify" />
	</form>
</body>
</html>