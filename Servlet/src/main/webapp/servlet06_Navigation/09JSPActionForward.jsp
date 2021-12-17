<%@ page contentType="text/html;charset=UTF-8" %>

<br/><hr/>

	<h3>
	 ㅇ 09JSPActionForward.jsp 시작<br/>
	 
	 <!-- 
	 	o request Object Scope 공유유무 확인 (Data 추출유무)
	 	o request Object Scope Data 추출 가능 : response 전
	 	o request Object Scope Data 추출 불가 : response 후
	 -->
	 
	 <br/> request Object Scope 공유 유무 : <%= request.getAttribute("aaa") %> <br/><br/>
	
	 ㅇ 09JSPActionForward.jsp 끝 <br/> 
	</h3>	

<hr/><br/>
	