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
		function handleBtnUpdate(){
			if(${board.bpassword!=null}){
				var bpassword=$("#bpassword").val();
				if(bpassword ==""){
					$("#bpassword").attr("placeholder","비밀번호를 입력하셔야 합니다.");
					$("#bpassword").css("border-color", "red");
					return;
				} 
				$.ajax({
					url:"exam05CheckBpassword",
					method:"post",
					data:{"bno":"${board.bno}", "bpassword":bpassword},
					success:function(data){
						if(data.result=="success"){
							location.href="exam05Update?bno=${board.bno}"
						}else{
							$("#bpassword").val("");
							$("#bpassword").attr("placeholder","비밀번호가 다릅니다.");
							$("#bpassword").css("border-color", "red");
						}
					}
				});
			}else{
				location.href="exam05Update?bno=${board.bno}"
			}
			
		}
		function handleBtnDelete(){
			if(${board.bpassword!=null}){
				var bpassword=$("#bpassword").val();
				if(bpassword ==""){
					$("#bpassword").attr("placeholder","비밀번호를 입력하셔야 합니다.");
					$("#bpassword").css("border-color", "red");
					return;
				} 
				$.ajax({
					url:"exam05CheckBpassword",
					method:"post",
					data:{"bno":"${board.bno}", "bpassword":bpassword},
					success:function(data){
						if(data.result=="success"){
							location.href="exam05Delete?bno=${board.bno}"
						}else{
							$("#bpassword").val("");
							$("#bpassword").attr("placeholder","비밀번호가 다릅니다.");
							$("#bpassword").css("border-color", "red");
						}
					}
				});
			}else{
				location.href="exam05Delete?bno=${board.bno}"
			}		
		}
	</script>
  </head>
	<body>
		<h4>Detail</h4>	
		<form method="post" enctype="multipart/form-data" >
	<div class="form-group">
	  <div class="input-group">
	    <span class="input-group-addon">
		<span class="glyphicon glyphicon-user"></span>
	    </span>
	    <input type="text" class="form-control" placeholder="번호" name="bno" value="${board.bno}" disabled="disabled"/>
	  </div>
	</div>
	<div class="form-group">
	  <div class="input-group">
	    <span class="input-group-addon">
		<span class="glyphicon glyphicon-user"></span>
	    </span>
	    <input type="text" class="form-control" placeholder="Title" name="btitle" value="${board.btitle}" disabled="disabled"/>
	  </div>
	</div>
	<div class="form-group">
	  <div class="input-group">
	    <span class="input-group-addon">
		<span class="glyphicon glyphicon-tag"></span>
	    </span>
	    <input type="text" class="form-control" placeholder="Writer" name="bwriter" value="${board.bwriter}" disabled="disabled"/>
	  </div>
	</div>
	<div class="form-group">
	  <div class="input-group">
	    <span class="input-group-addon">
		<span class="glyphicon glyphicon-lock"></span>
	    </span>
	    <input type="text" class="form-control" placeholder="Date" name="bdate" value="${board.bdate}" disabled="disabled"/>
	  </div>
	</div>
	<div class="form-group">
	  <div class="input-group">
	    <span class="input-group-addon">
		<span class="glyphicon glyphicon-lock"></span>
	    </span>
	    <input type="number" class="form-control" placeholder="HitCount" name="bhitcount" value="${board.bhitcount}" disabled="disabled"/>
	  </div>
	</div>
	<div class="form-group">
	  <div class="input-group">
	    <span class="input-group-addon">
		<span class="glyphicon glyphicon-lock"></span>
	    </span>
	    <textarea rows="5" cols="30" class="form-control" placeholder="Content" name="bcontent" disabled="disabled">${board.bcontent}</textarea>
	  </div>
	</div>
	
	<c:if test="${board.bpassword!=null }">
	<div class="form-group">
	  <div class="input-group">
	    <span class="input-group-addon">
		<span class="glyphicon glyphicon-lock"></span>
	    </span>
	    <input type="password"  id="bpassword"  class="form-control" placeholder="Password" name="bpassword" />
	  </div>
	</div>
	</c:if>
	
	
	
	    
	  <div class="form-group">
	    <div class="input-group">
		<span class="input-group-addon">
		  <span class="glyphicon glyphicon-camera"></span>
		</span>
		<a href="#" class="form-control">${board.boriginalfilename}</a>
	  </div>
	</div>

	<a href="exam05" class="btn btn-success">목록</a>
	<input onclick="handleBtnUpdate()" type="button"  class="btn btn-warning" value="수정"/>
	<input onclick="handleBtnDelete()" type="button"  class="btn btn-danger" value="삭제"/>
	
	<!-- 
		<button>버튼 </button>               //submit 기능
		<input type="button" value="버튼"/>
		<input type="submit" value="버튼"/>  //submit 기능
		<input type="cancel" value="버튼"/>
		
		<input type="image" src="버튼.png"/>  //submit 기능 
		<img src "버튼.png"/>
	 -->
    </form>
	</body>
</html>