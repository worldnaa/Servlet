package servlet04_JS.JSP;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RequestScopeTest extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html;charset=EUC-KR");
		PrintWriter out = response.getWriter(); 
		
		Integer count = (Integer)request.getAttribute("count");
		
		if(count == null) {
			out.println(":: 1 번째 Request ::");
			request.setAttribute("count", new Integer(1));
		}else {
			int changeCount = count.intValue()+1;
			out.println(":: "+changeCount+" 번째 Request ::");
			
			request.setAttribute("count", new Integer(changeCount));
		}
	}//end of service
}//end of class
