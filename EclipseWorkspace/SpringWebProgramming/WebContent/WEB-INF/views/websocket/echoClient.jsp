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
	<script>
		var ws=null;
		function handleBtnConnect(){
			 ws = new WebSocket("ws://"+window.location.host+"/SpringWebProgramming/websocket/echo");
			 ws.onopen=handleOnOpen;
			 
			 ws.onmessage = handleOnMessage;
			 
			 ws.onclose = handleOnClose;
		}
		
		function handleOnOpen(){
			display("[연결성공]");
		}
		function handleOnMessage(event){
			var strMessage= event.data;
			$("#divDisplay").append("[echo]"+strMessage);
		}
		function handleOnClose(){
			display("[연결끊김]");
		}
		
		function handleBtnDisconnect(){
			if(ws!=null){
				ws.close();
				ws=null;
			}
		}
		
		function handleBtnSend(){
			var strMessage=$("#txtMessage").val();
			ws.send(strMessage);
		}
		
		function display(message){
			$("#divDisplay").append("<span style='display:block'>"+message+"</span>");
			if($("#divDisplay span").length>20){
				$("#divDisplay span").first().remove();
			}
			$("#divDisplay").scrollTop($("#divDisplay").height());
		}
	</script>
  </head>
	<body>
		<h3>WebSocket-Echo</h3>
		<hr/>
		<div>
		<button id="btnConnect" onclick="handleBtnConnect()" class="btn btn-warning">연결하기</button>
		<button id="btnDisConnect" onclick="handleBtnDisconnect()" class="btn btn-danger">연결끊기</button>
		</div>
		<div>
			<input id="txtMessage" type="text"/>
			<button id="btnSend" onclick="handleBtnSend()" class = "btn btn-info">메시지 보내기</button>
		</div>
		<div>
			<div id="divDisplay" style="width:600px; height:300px; padding:5px; overflow-y:scroll; border:1px solid black;"></div>
		</div>
	</body>
</html>