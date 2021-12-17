<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="connectionPool.service.user.vo.UserVO" %>

<!-- 
	:: WorkFlow Control : 방어적 코딩 (로그인 유무 확인)
	:: 로그인 회원은 session Object Scope 에 userVO 가 존재하며, Field 의 active 는 true
-->
<%
	UserVO userVO = (UserVO)session.getAttribute("userVO");
	if(userVO == null){
		userVO = new UserVO();
	}
%>

<!-- 
	==> 미 login 한 회원 : UserVO.active false
		1. 로그인 page 로 include
		2. 회원가입 page 로 이동할 수 있는 link display
	
	==> 기 login 한 회원 : UserVO.active true
		1. 회원 ID display
		2. 로그아웃 버튼 display 
-->
<% if(! userVO.isActive()) {%>
	<!-- 1. 로그인 page 로 include -->
	<jsp:include page="login.html"/>
	<br/><br/>
	
	<!-- 2. 회원가입 page 로 이동할 수 있는 link display -->
	<a href="/Servlet/servlet04_JS&JSP/addUser.html">회원가입</a>

<% }else { %>	
	<!-- 1. 회원 ID display -->
	<%= userVO.getId() %> 님 로그인 하셨습니다.
	<br/><br/>
	
	<!-- 2. 로그아웃 버튼 display -->
	<form method="post" action="<%= request.getRequestURI() %>">
		URL : <%= request.getRequestURL()%><br/>
		URI : <%= request.getRequestURI()%><br/>
		<input type="submit" value="Logout"/>
	</form>
	<br/><br/>
<% } %>

<!-- Get / Post 방식 이용 :: 1개의 page로 2개의 내용 display -->
<%
	if(request.getMethod().equals("POST")){
		
		// logout 의 3가지 방법
		
		// 1. session 을 종료
		// session.invalidate();
		
		// 2. login 정보를 갖는 userVO session Object Scope remove  
		session.removeAttribute("userVO");
		
		// 3. login 정보를 갖는 userVO의 Field active를 false로 변경
		// userVO.setActive(false);
		
		// logout 후 로그인 page로 sendRedirect
		response.sendRedirect("/Servlet/servlet04_JS&JSP/logout.jsp");
	}
%>








