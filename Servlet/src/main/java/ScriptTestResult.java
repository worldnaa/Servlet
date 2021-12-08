import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/ScriptTestResult")
public class ScriptTestResult extends HttpServlet {
	
	// Field
	// Method
	public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException,IOException {

		// 한글처리
		req.setCharacterEncoding("UTF-8");
		res.setContentType("text/html;charset=UTF-8");
		
		// PrintWriter 인스턴스 생성을 Encapsulation 한 API 사용 Stream 생성
		PrintWriter out = res.getWriter();
		
		// Client Form Data 처리 
		String name = req.getParameter("myname");
		String passwd = req.getParameter("mypasswd");
		String email = req.getParameter("myemail");
		String addr = req.getParameter("myaddr");
		
		out.println("<html>");
		out.println("<body>");
		out.println("<h1> ScriptTest Result </h1>");
		out.println("<p> name : " + name + "</p>");
		out.println("<P> pass : " + passwd + "</p>");
		out.println("<P> email : " + email + "</p>");
		out.println("<P> addr : " + addr + "</p>");
		out.println("</body>");
		out.println("</html>");

	}//end of service
	
}//end of class
