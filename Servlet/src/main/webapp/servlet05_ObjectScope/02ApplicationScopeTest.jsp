<%@ page contentType="text/html; charset=UTF-8" %>

<%
	//내장객체 : request, session, out, application 등등
	// Scriptlet, Expression Tag 에서 사용가능
	
	// 1. application Object Scope 에서 "count" 추출
	Integer count = (Integer)application.getAttribute("count");

	// 2. application 에 count 가 없다면 => name은 count / value는 new Integer(1) 로 생성
	if(count == null){
		out.println(":: 해당 페이지 1 번째 출력 ::");
		application.setAttribute("count", new Integer(1)); // new Integer(1) => wraper class
	}
	
	// 3. application 에 count 가 있다면
	// => application Object Scope에서 추출한 값 출력하고, count 값을 증가(+1)시킨 후 다시 application Object Scope에 저장
	else{
		int changeCount = count.intValue()+1;
		out.println(":: 해당 페이지 " + changeCount + " 번째 출력 ::");
		
		application.setAttribute("count",new Integer(changeCount));
	}
%>

<!-- 결과 : 새로고침 혹은 새탭에서 열어도 count 계속 증가 (공유) / 시크릿창에서 열어도 count 증가 (서버가 내려가지 않는 이상 계속 유지)  -->