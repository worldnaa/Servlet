package servlet01_GetPost;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebServlet("/MultiCheck02")
public class MultiCheck02 extends HttpServlet{

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{

		req.setCharacterEncoding("UTF-8");		
		res.setContentType("text/html;charset=UTF-8");
		PrintWriter out = res.getWriter();
		
		out.println("<html>");
		out.println("<head></head>");
		out.println("<boby><center><h2>Client에서 전송된 내용</h2></center><p>");

		// 1. QueryString(name=value) 의 name 을 return 하는 getParameterNames() 
		// 2. getParameter("name") 의 name 하드코딩 않음
		// but 선택한 것 중에서 최상단 항목 한 가지만 나온다
		Enumeration<String> en = req.getParameterNames();
		
		while(en.hasMoreElements()){
			String name = en.nextElement();
			String value = req.getParameter(name);
			out.println("<li> "+name+" : "+value);
		}
        
		out.println("</body>");
		out.println("</html>");
	}

}//end of class
