<%@ page contentType="text/html;charset=UTF-8" %>

<br/><hr/>

	<h3>
	 ㅇ 05JSPActionInclude.jsp 시작<br/><br/>
	 
	 	request,session,application  Object Scope  Data 추출 <br/><br/>
	
		request ObjectScope 추출 Data : <%= request.getAttribute("aaa") %><br/>
		session ObjectScope 추출 Data : <%= session.getAttribute("bbb") %><br/>
		application ObjectScope 추출 Data : <%= application.getAttribute("ccc") %><br/><br/>
	
	 ㅇ 05JSPActionInclude.jsp 끝 <br/> 
	</h3>
	
	<!-- 아래을 주석 풀면 error 발생 (변수값이 해당 파일에 선언되어 있지 않기 때문) -->
	<%-- <%= value %> --%>
	
<hr/><br/>
	