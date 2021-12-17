<%@ page contentType="text/html;charset=UTF-8" %>

<!-- 1. 아래의 page 지시자 주석처리 전 / 후 실행 :  차이점 확인 -->
<!-- 아래 코드 주석 처리 후 실행 시 : 500 에러 발생 -->
<!-- 아래 코드 주석 해제 후 실행 시 : 지정된 에러페이지로 이동 -->
<%@ page errorPage="/servlet04_JS&JSP/JSPErrorPage.jsp" %>

<%-- 
	2. 위의 errorPage=path 를 아래의 각각 path 로 변경하여 확인 :: 404 Error가 발생하는 이유 이해
	<%@ page errorPage="http://localhost:8080/Servlet/servlet04_JS&JSP/JSPErrorPage.jsp" %>
	=> 결과: [/servlet04_JS&JSP/http:/localhost:8080/Servlet/servlet04_JS&JSP/JSPErrorPage.jsp]을(를) 찾을 수 없습니다.
	
	<%@ page errorPage="/Servlet/servlet04_JS&JSP/JSPErrorPage.jsp" %>
	=> 결과: [/Servlet/servlet04_JS&JSP/JSPErrorPage.jsp]을(를) 찾을 수 없습니다.
	
	<%@ page errorPage="/servlet04_JS&JSP/JSPErrorPage.jsp" %>
	=> 결과: 성공 (에러페이지 나옴)

	<%@ page errorPage="Servlet/servlet04_JS&JSP/JSPErrorPage.jsp" %>
	=> 결과: [/servlet04_JS&JSP/Servlet/servlet04_JS&JSP/JSPErrorPage.jsp]을(를) 찾을 수 없습니다.
	
	<%@ page errorPage="servlet04_JS&JSP/JSPErrorPage.jsp" %>
	=> 결과: [/servlet04_JS&JSP/servlet04_JS&JSP/JSPErrorPage.jsp]을(를) 찾을 수 없습니다.
	
	<%@ page errorPage="/JSPErrorPage.jsp" %>
	=> 결과: [/03JSPErrorPage.jsp]을(를) 찾을 수 없습니다.
	
	==> web application(ContextRoot :: /Servlet) 에서 출발(?)
--%>
 
 
<!-- .java / .class 파일이 생성되는 위치 경로 -->
<!-- "C:\workspace\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\work\Catalina\localhost\Servlet\org\apache\jsp\servlet04_005fJS_0026JSP\_01JSPDirectivePageTest01_jsp.java" -->


<!-- 3. 내부적으로 I/O Buffer의 사용유무 확인 :: 주석을 풀고 실행, 주석 처리 후 실행 차이점 확인  -->
<!-- JSP페이지는 생생된 결과를 곧바로 웹 브라우저에 전송하지 않고, 출력 버퍼라고 불리는 곳에 임시로 출력 결과를 저장했다가 한번에 웹브라우저에 전송 -->
<!-- 버퍼를 사용하고 싶지 않은 경우에는 buffer속성의 값을 "none"으로 저정 -->

<!-- 코드 주석 처리 후 실행 시 : 버퍼사용O , 예외가 발생했기에 아래 <body> 안의 코드 실행 안 됨 -->
<!-- 코드 주석 해제 후 실행 시 : 버퍼사용X , 예외가 발생했는데도 아래 <body> 안의 코드 실행 됨 -->
	<%@page buffer="none" %>

<html>
<body>

	안녕하세요  html 시작<br/>
    buffer 전체 크기  : <%= out.getBufferSize() %><br/>
	buffer 잔여 크기  : <%= out.getRemaining() %><br/>
	
	<hr/>
	인위적 Exception 발생...

	<% int number = 0; %>
	<% number = Integer.parseInt("a"); %>
	<%="number : " + number %>
	<hr/>
	
	안녕하세요  html 끝<br/>

</body>
</html>