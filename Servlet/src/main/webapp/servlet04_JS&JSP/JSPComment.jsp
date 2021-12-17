<%@ page contentType="text/html; charset=UTF-8" %>

<html>
	<head></head>
	<body>
		1. 주석문 연습입니다. <br/> <!-- .java / 브라우저 소스 / 브라우저 화면에 OK -->
		
		<%
		String str1 = "주석 1";  // .java 에 OK (브라우저 소스 / 브라우저 화면에는 X)
		String str2 = "주석 2";  // .java 에 OK (브라우저 소스 / 브라우저 화면에는 X)
		%>

		<!-- 
			<%= str1 %>         // .java / 브라우저 소스에 OK (브라우저 화면에는 X)
			나는 html 주석입니다.  // .java / 브라우저 소스에 OK (브라우저 화면에는 X)
		-->
	
		<!-- 
			<%= str2 %>         // .java / 브라우저 소스에 OK (브라우저 화면에는 X)
			나는 html 주석입니다.  // .java / 브라우저 소스에 OK (브라우저 화면에는 X)
		-->
	
		<%--
			나는 jsp 주석입니다.   // .java / 브라우저 소스 / 브라우저 화면에 X
		--%>
	
		<%
			//주석처리만 했음      // .java 에 OK (브라우저 소스 / 브라우저 화면에는 X)
			//개행처리라 함은...   // .java 에 OK (브라우저 소스 / 브라우저 화면에는 X)
		%>

	</body>
</html>

<!--                            // .java / 브라우저 소스에 OK (브라우저 화면에는 X)
	:: 실행후..
	- Browser 화면
	- Browser 화면에서 소스보기한 내용
	- ~~.jsp 파일
	- ~~.java 파일
	동시 오픈하여
	html주석, JSP주석, java주석 확인
-->













