package servlet04_ObjectScope;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/servlet04_ObjectScope/SessionScopeTest") // web.xml에서 servlet mapping 생략가능 
public class SessionScopeTest extends HttpServlet {
	
	// service()
	public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		res.setContentType("text/html;charset=UTF-8");
		PrintWriter out = res.getWriter();
		
		// 1. HttpSession 객체 Get
		HttpSession session = req.getSession(true);
		
		// 2. session Object Scope 에 "count" 추출
		Integer count = (Integer)session.getAttribute("count");
		
		// 3. session Object Scope 에 "count" 가 없다면
		// ==> name : "count" / value : new Integer(1) 생성
		if(count == null) {
			out.println(":: Browser 켜고 1 번째 방문 ::");
			session.setAttribute("count", new Integer(1));
		}
		
		// 3. session Object Scope 에 "count" 가 있다면
		// ==> count 값을 증가(+1)시키고, 다시 session Object Scope 에 저장
		else {
			int changeCount = count.intValue()+1;
			out.println(":: Browser 켜고 "+changeCount+" 번째 방문 ::");
			
			session.setAttribute("count", new Integer(changeCount));
		}
		
	}//end of service
}//end of class

