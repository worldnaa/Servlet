<%@ page contentType="text/html; charset=UTF-8"%>

<%@ page import="connectionPool.service.user.vo.UserVO" %>
<%@ page import="connectionPool.service.user.dao.UserDao" %>

<%
	
	// 방어적 코딩 /  WorkFlow Control
	if( request.getMethod().equals("GET") ){
		response.sendRedirect("addUser.html");
		return;
	}

	request.setCharacterEncoding("UTF-8"); 
	
	// Client Form Data 처리
	int no = Integer.parseInt(request.getParameter("no"));
	String id = request.getParameter("id");
	String name = request.getParameter("name");
	String pwd = request.getParameter("pwd");
	
	// UserVO instance 생성 및 Client Form Data 전달(Binding)
	UserVO userVO = new UserVO();
	userVO.setNo(no);
	userVO.setId(id);
	userVO.setName(name);
	userVO.setPwd(pwd);
	
	// DB  접근 회원정보 Insert
	UserDao userDao = new UserDao();
%>

<%if(  userDao.addUser(userVO) ){%>
		<%= userVO.getId() %> 회원 가입 축하합니다.
<%} else {  %>
		다시 기입요망<br/><hr/>
		<jsp:include page="addUser.html" />
<%}%>






