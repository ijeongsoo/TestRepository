<%-- 
    Document   : exam07
    Created on : 2017. 4. 27, 오전 9:34:09
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
  </head>
  <body>
    <h1>배열</h1>
    <script>
	var arr1 = ["Saab", "Volvo", "BMW"];
	console.log(arr1[0]);
	console.log(arr1.length);
	
	var arr2 = new Array("Saab", "Volvo", "BMW");
	arr2.sort();
	console.log(arr2);
	
	var arr3=["Banana", "Orange", "Apple", "Mango"];
	arr3.push("Lemon");
	console.log(arr3);
	arr3[5]="포도";
	console.log(arr3);
	
	arr3.splice(2,1,"Kiwi");
	console.log(arr3);

    </script>
  </body>
</html>
