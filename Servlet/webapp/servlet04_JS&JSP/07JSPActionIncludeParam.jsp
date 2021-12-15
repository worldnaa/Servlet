<%@ page contentType="text/html;charset=UTF-8" %>

<br/><hr/>

	<h3>
	 ㅇ 07JSPActionIncludeParam.jsp 시작<br/><br/>
	 
	 	request,session,application  Object Scope  Data 추출 <br/><br/>
	
		request ObjectScope 추출 Data : <%= request.getAttribute("aaa") %><br/>
		session ObjectScope 추출 Data : <%= session.getAttribute("bbb") %><br/>
		application ObjectScope 추출 Data : <%= application.getAttribute("ccc") %><br/><br/>
	
	 ㅇ 07JSPActionIncludeParam.jsp 끝 <br/> 
	</h3>
	
	<%-- 
		<%= request.getParameter("~~") %> - <jsp:param ~~ /> 으로 전달받은 Data 추출 
										  - String 만 리턴 
	--%>
	param으로 넘어온 str값 : <%= request.getParameter("str") %><br/><br/>

<hr/><br/>
	