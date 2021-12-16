<%@ page contentType="text/html; charset=UTF-8"%>

<%@page import="java.util.ArrayList"%>
<%@page import="connectionPool.service.user.vo.UserVO" %>
<%@page import="connectionPool.service.user.dao.UserDao" %>

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
		1. DAO 접근 회원정보 GET
		2. 회원정보 display
-->
<% if(! userVO.isActive()) {%>
	<!-- 1. 로그인 page 로 include -->
	<jsp:include page="login.html"/>
	<br/><br/>
	
	<!-- 2. 회원가입 page 로 이동할 수 있는 link display -->
	<a href="/Servlet/servlet04_JS&JSP/addUser.html">회원가입</a>
	
<% }else{ %>
	<center><h1>회원가입한 전체 목록</h1></center>
		<center>
			<table border='1'>
				<tr>
					<th>번호</th>
					<th>아이디</th>
					<th>이름</th>
					<th>비밀번호</th>
				</tr>
				<% UserDao userDao = new UserDao(); %>
				<% ArrayList<UserVO> arrayList = userDao.getUserList(); %>
				
				<% for(int i=0; i<arrayList.size(); i++) {%>
					<% UserVO user = arrayList.get(i); %>
					<tr>
						<td><%=user.getNo()%></td>
						<td><%=user.getId()%></td>
						<td><%=user.getName()%></td>
						<td><%=user.getPwd()%></td>
					</tr>
				<% } %>
			</table>	
		</center>
<% } %>







