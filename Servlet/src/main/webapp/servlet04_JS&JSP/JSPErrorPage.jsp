<%@ page contentType="text/html;charset=UTF-8" %>

<!-- 
	1. error 를 처리하는 page 는 isErrorPage 속성 : true 로 설정
	2. error 를 처리하는 page 는 반드시 true 로 설정한다면 default 는 ? 
	3. error 를 처리하는 page 의 isErrorPage 속성의 default는 false (주석처리 시 에러발생)
-->
<%@ page isErrorPage="true" %>

<% System.out.println("03JSPErrorPage.jsp 시작");  %>

	<br/>
	<hr/>
	여기는 error page 시작 <br/><br/>

	exception : <%= exception %><br/>
	exception.toString() : <%= exception.toString() %><br/>
	exception.getMessage() : <%= exception.getMessage() %><br/><br/>
	
	여기는 error page 끝 <br/>
	<hr/>
	<br/>

<% System.out.println("03JSPErrorPage.jsp 끝");  %>