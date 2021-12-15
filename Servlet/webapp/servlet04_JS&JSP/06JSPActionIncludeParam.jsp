<%@ page contentType="text/html;charset=UTF-8" %>

<html>
<body>

	::  06JSPActionIncludeParam.jsp 시작 <br/>

<%
	// Scriptlet tag 변수 선언 :: service() Method  local variable
	String value = "local variable";

	// request,session,application  ObjectScope  Data 저장 ==> Object 리턴! 
	request.setAttribute("aaa",new String("request ObjectScope 저장된 문자열")); 
	session.setAttribute("bbb",new String("session ObjectScope 저장된 문자열"));
	application.setAttribute("ccc",new String("application ObjectScope 저장된 문자열"));
%>

	<jsp:include  page="07JSPActionIncludeParam.jsp">
		<jsp:param name="str" value="<%= value %>"/>
	</jsp:include>
	
	<%-- <jsp:param> - forward 및 include 태그에 데이터 전달을 목적으로 사용되는 태그
	                 - name(이름)과 value(값)으로 이루어져 있다
	                 - 단독으로 사용되지 못하며 <jsp:include>나 <jsp:forward>의 자식 태그로 추가한다
	                 - 다른 페이지에 여러 개의 정보를 전송해야 할 때는 다중의 param 액션 태그를 사용한다 --%>

	::  06JSPActionIncludeParam.jsp 끝 <br/>

</body>
</html>