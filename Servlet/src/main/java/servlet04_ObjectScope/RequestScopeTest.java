package servlet04_ObjectScope;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/servlet04_ObjectScope/RequestScopeTest") // web.xml에서 servlet mapping 생략가능 
public class RequestScopeTest extends HttpServlet {
	
	// service()
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter(); 
		
		// 1. request Object Scope 에 "count" 추출
		Integer count = (Integer)request.getAttribute("count");
		
		// 2. request Object Scope 에 "count" 가 없다면
		// ==> name : "count" / value : new Integer(1) 생성
		if(count == null) {
			out.println(":: 1 번째 Request ::");
			request.setAttribute("count", new Integer(1));
		}
		
		// 3. request Object Scope 에 "count" 가 있다면
		// ==> count 값을 증가(+1)시키고, 다시 request Object Scope 에 저장
		else {
			int changeCount = count.intValue()+1;
			out.println(":: "+changeCount+" 번째 Request ::");
			
			request.setAttribute("count", new Integer(changeCount));
		}
		
	}//end of service
}//end of class
