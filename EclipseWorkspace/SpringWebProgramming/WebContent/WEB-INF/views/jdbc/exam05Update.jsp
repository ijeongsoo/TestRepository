<%@page contentType="text/html; charset=UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no">
    <title>JSP Page</title>
    <link href="<%=application.getContextPath() %>/resources/bootstrap-3.3.7/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
    <script src="<%=application.getContextPath() %>/resources/jquery/jquery-3.2.1.min.js" type="text/javascript"></script>
    <script src="<%=application.getContextPath() %>/resources/bootstrap-3.3.7/js/bootstrap.min.js" type="text/javascript"></script>
	<script type="text/javascript">
		function fileChange(){
			if($("#battach")[0].files.length !=0){
				var originalfilename = $("#battach")[0].files[0].name;
				$("#spanFileName").text(originalfilename);
			}
		}
	</script>
  </head>
	<body>
		<h4>Modify into Board</h4>	
		<form method="post" enctype="multipart/form-data" >
		<input type="hidden" name="bno" value="${board.bno}"/>
	<div class="form-group">
	  <div class="input-group">
	    <span class="input-group-addon">
		<span class="glyphicon glyphicon-user"></span>
	    </span>
	    <input type="text" class="form-control" placeholder="Title" name="btitle" value ="${board.btitle}"/>
	  </div>
	</div>
	<div class="form-group">
	  <div class="input-group">
	    <span class="input-group-addon">
		<span class="glyphicon glyphicon-tag"></span>
	    </span>
	    <input type="text" class="form-control" placeholder="Writer" name="bwriter" value ="${board.bwriter}" disabled/>
	  </div>
	</div>
	<div class="form-group">
	  <div class="input-group">
	    <span class="input-group-addon">
		<span class="glyphicon glyphicon-lock"></span>
	    </span>
	    <input type="password" class="form-control" placeholder="Password" name="bpassword" value="${board.bpassword}" />
	  </div>
	</div>
	<div class="form-group">
	  <div class="input-group">
	    <span class="input-group-addon">
		<span class="glyphicon glyphicon-lock"></span>
	    </span>
	    <textarea rows="5" cols="30" class="form-control" placeholder="Content" name="bcontent">${board.bcontent}</textarea>
	  </div>
	</div>
	
	
	    
	    <div class="form-group">
	    <div class="input-group" style="height:47px;">
		<span class="input-group-addon">
		  <span class="glyphicon glyphicon-camera"></span>
		</span>
		<div class="form-control" style="height:47px;">
		<span id="spanFileName">${board.boriginalfilename}</span>
		<label for="battach" class="btn btn-default">변경</label>
		<input type="file" id="battach" style="visibility:hidden" onchange="fileChange()" name="battach" />
	  	</div>
	  </div>
	</div>

	<input type="submit" class="btn btn-info" value="Modify"/>
    </form>
	</body>
</html>