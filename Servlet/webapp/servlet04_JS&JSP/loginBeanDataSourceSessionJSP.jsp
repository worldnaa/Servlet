<%@ page contentType="text/html; charset=UTF-8"%>

<%
	request.setCharacterEncoding("UTF-8");
	response.setContentType("text/html;charset=UTF-8");
	//PrintWriter out = response.getWriter();

	// Client Form Data 처리
	String id = request.getParameter("id");
	String pwd = request.getParameter("pwd");
	
	// session 유무확인 :: 새로운 HttpSession 생성 or 기존 HttpSession Get
	// HttpSession session = req.getSession(true);
	
	// 기 login 한 회원 :: session 에 저장된 UserVO Get
	// 미 login 한 회원 :: session 에 저장된 UserVO 없으므로 null Get
	// 아래 servlet02_JDBC.UserVO 처럼 모든 경로를 써주거나, <%@page import="어쩌구"> 와 같이 import 하고 클래스명만 적어준다 
	servlet02_JDBC.UserVO userVO = (servlet02_JDBC.UserVO)session.getAttribute("userVO");
	System.out.println("session에 저장된 UserVO 유무확인 : "+userVO);

	// 입력 값의 유효성을 check 하는 if문 (DB 접근 불필요)
	if(!(id==null || id.equals(""))){
		// UserVO 인스턴스 생성 및 Client Form Data 전달 (Binding)
		userVO = new servlet02_JDBC.UserVO();
		userVO.setId(id);
		userVO.setPwd(pwd);
		
		// DB 접근 Data 검색, 비교하여 UserVO.active 의 true / false 변경
		servlet02_JDBC.UserDataSourceDao userDataSourceDao = new servlet02_JDBC.UserDataSourceDao();
		userDataSourceDao.getUser(userVO);
	}
%>

<html>
<head></head>
<body>
	<h2>Login 화면</h2>
		
		<% if (userVO != null && userVO.isActive()) { %>
				<%=id%>님 환영합니다.
				<!-- Login이 정상적으로 이루어진 경우 :: session에 로그인 정보로 UserVO instance 저장 -->
				<% session.setAttribute("userVO", userVO); %>
		<% }else { %>
				Login 실패 id,pwd를 확인하세요.
		<% } %>
			
	<p><p><a href='/Servlet/servlet04_JS&JSP/loginBeanDataSourceSessionJSP.html'>뒤로</a>
</body>
</html>