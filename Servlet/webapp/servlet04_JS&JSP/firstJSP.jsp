<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>firstJSP</title>
</head>
<body>
<h1>
		<%= "안녕하세요. HelloJSP 입니다." %><br/><hr/>
		client 에서 요청하신 /examples/firstJSP.jsp 입니다<br/>
		JSP는 Java web programming 기술 입니다<br/>
	</h1>
<hr>
</body>
</html>
<!-- 
	1. [TOMCAT_HONE]\webapps\examples\     폴더에 copy
	2. browser 에서
		http://127.0.0.1:8080/examples/firstJSP.jsp               로 호출
-->