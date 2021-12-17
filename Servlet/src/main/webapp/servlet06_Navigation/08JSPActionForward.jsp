<%@ page contentType="text/html;charset=UTF-8" %>

<html>
<body>

	 :: 08JSPActionForward.jsp 시작 <br/>
	 
	 <% request.setAttribute("aaa", new String("연결됨")); %><br/>

	<jsp:forward page="09JSPActionForward.jsp" />
	
	<%-- <jsp:forward page="이동할 페이지" />  -  request 스코프에 담긴 값이 유효하다 (request, response 가 유지된다)
											-  이동된 url이 화면에 안 보인다 (사용자는 이동했는지 알 수 없음) --%>  
	
	 :: 08JSPActionForward.jsp 끝 <br/>
	
</body>
</html>	