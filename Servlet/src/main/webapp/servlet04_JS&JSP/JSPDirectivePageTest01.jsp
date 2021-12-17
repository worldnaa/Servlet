<%@ page contentType="text/html;charset=UTF-8" %>
<!-- ==> java.lang / javax.servlet.* / javax.servlet.http.* / javax.servlet.jsp.* 을 제외하고는 import 해야한다 -->
<%@ page import="java.util.*" %>

<%@ page language="java" %>       <!-- Default라서 안 써도 됨 -->
<%@ page info="처음 작성하는 JSP" %> <!-- info : to String과 비슷하며 잘 안쓰임 -->

<%@ page session="true" %>		  <!-- Default라서 안 써도 됨 -->
<%@ page isThreadSafe="true" %>   <!-- Default라서 안 써도 됨 -->

<%-- 
	JSP 주석 : JSP Container가 java File 변환 시 주석인식
	<%@ page extends="java.util.Vector"%> ==> 사용하면 X
	==> JSP 주석 사용 시 .java로 안 간다!
--%>

<%
	String value = "지역변수";
	System.out.println(":: " + value);

	Calendar calendar = Calendar.getInstance();
	int year = calendar.get(Calendar.YEAR);
	System.out.println(":: " + year + "년");

	String info = getServletInfo();
	System.out.println(":: information : " + info);
%>

<html>
<head></head>
<body>
	안녕하세요 html 시작<br/>
	<hr/>
	<%=":: " + value %><br/>
	<%=":: " + year + "년" %><br/>
	<%=":: information : " + info %><br/>
	<hr/>
	안녕하세요 html 끝<br/>
</body>
</html>

<!-- 
- .java 가 안 만들어져 있으면 => 태그 에러 (jsp 파일 수정해야 함)
- .class 가 안 만들어져 있으면 => 컴파일 에러 (java 파일 수정해야 함)
- .java/.class 둘 다 있는데 안 되면 => 런타임 에러
 -->