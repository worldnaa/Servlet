<%@ page contentType="text/html;charset=UTF-8" %>

<html>
<body>

	 :: 10ResponseSendredirect.jsp 시작 <br/>
	 
	 <% request.setAttribute("aaa", new String("연결됨")); %><br/>
	 
	 <!-- response.sendRedirect() 는 URL, URI, Relative URI 사용가능 -->
	 <% //response.sendRedirect("09JSPActionForward.jsp"); %>
	 <% response.sendRedirect("http://localhost:8080/Servlet/servlet04_JS&JSP/09JSPActionForward.jsp"); %>
	 <% //response.sendRedirect("http://www.daum.net"); %>
	 
	 <%-- <% response.sendRedirect("이동할 페이지"); %>  -  클라이언트가 새로 페이지를 요청한 것과 같은 방식으로 페이지가 이동된다
	 												  -  request, response 가 유지되지 않는다 (새로 만들어진다)
											          -  이동된 url이 화면에 보인다 --%>  
	 
	 :: 10ResponseSendredirect.jsp 끝 <br/>
	
</body>
</html>	