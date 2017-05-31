<%-- 
    Document   : exam01
    Created on : 2017. 4. 26, 오후 12:37:38
    Author     : ijeongsu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no">
    <title>JSP Page</title>
    <link href="<%=application.getContextPath() %>/resources/bootstrap-3.3.7/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
    <script src="<%=application.getContextPath() %>/resources/jquery/jquery-3.2.1.min.js" type="text/javascript"></script>
    <script src="<%=application.getContextPath() %>/resources/bootstrap-3.3.7/js/bootstrap.min.js" type="text/javascript"></script>
    <style>
	div{
	  border: 1px solid black
	}
	</style>
	
  </head>
  <body>
    <div class="container" >
	<div class="row">
	  <div class="col-xs-7" style="padding: 0px;">
	    <div style="height: 50px; background-color: skyblue;"></div>
	  </div>	  
	  <div class="col-xs-5" style="padding: 0px;">
	    <div style="height: 50px; background-color: skyblue;"></div>
	  </div>
	</div>
	
	<div class="row">
	  <div class="col-xs-8">
	    <div class="row">
		<div class="col-xs-4" style="padding: 0px; height: 100px;">
		</div>
		<div class="col-xs-4" style="padding: 0px; height: 100px;">
		</div>
		<div class="col-xs-4" style="padding: 0px; height: 100px;">
		</div>
	    </div>
	    <div class="row">
		<div class="col-xs-3" style="padding: 0px; height: 200px;">
		</div>
		<div class="col-xs-3" style="padding: 0px; height: 200px;">
		</div>
		<div class="col-xs-3" style="padding: 0px; height: 200px;">
		</div>
		<div class="col-xs-3" style="padding: 0px; height: 200px;">
		</div>
	    </div>
	    <div class="row">
		<div class="col-xs-4" style="padding: 0px; height: 300px;">
		</div>
		<div class="col-xs-4" style="padding: 0px; height: 300px;">
		</div>
		<div class="col-xs-4" style="padding: 0px; height: 300px;">
		</div>
	    </div>
	  </div>
	  <div class="col-xs-4">
	    <div class="row">
		<div class="col-xs-12" style="padding: 0px; height: 200px;">
		</div>
	    </div>
	    <div class="row">
		<div class="col-xs-12" style="padding: 0px; height: 200px;">
		</div>
	    </div>
	    <div class="row">
		<div class="col-xs-6" style="padding: 0px; height: 200px;">
		</div>
		<div class="col-xs-6" style="padding: 0px; height: 200px;">
		</div>
	    </div>
	  </div>
	</div>
	
    </div>
  </body>
</html>
