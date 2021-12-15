<%@ page contentType="text/html; charset=UTF-8"%>

<%@page import="connectionPool.service.user.vo.UserVO" %>
<%@page import="connectionPool.service.user.dao.UserDao" %>

<!-- 방어적 코딩 / WorkFlow Control -->
<% if(request.getMethod().equals("GET")) {%>
	<jsp:forward page="login.html"/>
<% } %>

<%
	request.setCharacterEncoding("UTF-8");

	// Client Form Data 처리
	String id = request.getParameter("id");
	String pwd = request.getParameter("pwd");

	// UserVO 인스턴스 생성 및 Client Form Data 전달 (Binding)
	UserVO userVO = new UserVO();
	userVO.setId(id);
	userVO.setPwd(pwd);
	
	// DB 접근 Data 검색 비교 UserVO.active true/false 변경
	UserDao userDAO = new UserDao();
	userDAO.getUser(userVO);

%>

<html>
<head></head>
<body>
	<h2>Login 화면</h2>
		<% if (userVO.isActive()) { %>
			<%=id%>님 환영합니다.
			<% session.setAttribute("userVO", userVO); %>
		<% }else { %>
			id,pwd를 확인하세요.
		<% } %>
	<p><p><a href='/Servlet/servlet04_JS&JSP/login.html'>뒤로</a>
</body>
</html>