<%-- 
    Document   : exam02
    Created on : 2017. 5. 11, 오후 3:46:29
    Author     : ijeongsu
--%>

<%@page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no">
    <title>JSP Page</title>
    <link href="<%=application.getContextPath() %>/resources/bootstrap-3.3.7/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
    <script src="<%=application.getContextPath() %>/resources/jquery/jquery-3.2.1.min.js" type="text/javascript"></script>
    <script src="<%=application.getContextPath() %>/resources/bootstrap-3.3.7/js/bootstrap.min.js" type="text/javascript"></script>
  </head>
  <body>
    <h1>요청 HTTP 정보 얻기</h1>
    1.요청방식(method):${method}<br/>
    2.요청URI(uri):${uri}<br/>
    3.쿼리문자열:${queryString}<br/>
    4.type:${type}<br/>
    3.bno:${bno}<br/>
  </body>
</html>
