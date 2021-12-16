package servlet04_JS.JSP;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SessionScopeTest extends HttpServlet {
	
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		res.setContentType("text/html;charset=EUC-KR");
		PrintWriter out = res.getWriter();
		HttpSession session = req.getSession(true);
		Integer count = (Integer)session.getAttribute("count");
		
		if(count == null) {
			out.println(":: Browser 켜고 1 번째 방문 ::");
			session.setAttribute("count", new Integer(1));
		}else {
			int changeCount = count.intValue()+1;
			out.println(":: Browser 켜고 "+changeCount+" 번째 방문 ::");
			
			session.setAttribute("count", new Integer(changeCount));
		}
	}//end of service
}//end of class

