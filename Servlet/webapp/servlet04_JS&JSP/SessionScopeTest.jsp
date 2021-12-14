<%@ page contentType="text/html; charset=UTF-8" %>

<%
	// 내장객체 : request, session, out, application 등등
	// Scriptlet, Expression Tag 에서 사용가능
	
	// 1. session Object Scope 에서 "count" 추출
	Integer count = (Integer)session.getAttribute("count");

	// 2. session 에 count 가 없다면 => name은 count / value는 new Integer(1) 로 생성
	if(count == null){
		out.println(":: Browser 켜고 1 번째 방문 ::");
		session.setAttribute("count", new Integer(1)); // new Integer(1) => wraper class
	}
	
	// 3. session 에 count 가 있다면
	// => session Object Scope에서 추출한 값 출력하고, count 값을 증가(+1)시킨 후 다시 session Object Scope에 저장  
	else{
		int changeCount = count.intValue()+1;
		out.println(":: Browser 켜고 " + changeCount + " 번째 방문 ::");
		
		session.setAttribute("count",new Integer(changeCount));
	}
%>

<!-- 결과 : 새로고침 혹은 새탭에서 열어도 count 계속 증가 (공유) / 시크릿창에서 열면 다시 count (session이 끊기면 다시 count) -->

