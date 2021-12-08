import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/ScriptTest3Result")
public class ScriptTest3Result extends HttpServlet {
	
	// Field
	// Method
	public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException,IOException {

		// 한글처리
		req.setCharacterEncoding("UTF-8");
		res.setContentType("text/html;charset=UTF-8");
		
		// PrintWriter 인스턴스 생성을 Encapsulation 한 API 사용 Stream 생성
		PrintWriter out = res.getWriter();
		
		// Client Form Data 처리 
		String sport1 = req.getParameter("sport1");
		String sport2 = req.getParameter("sport2");
		String note1 = req.getParameter("note1");
		String note2 = req.getParameter("note2");
		
		out.println("<html>");
		out.println("<body>");
		out.println("<h1> ScriptTest Result </h1>");
		out.println("<p> sport1 : " + sport1 + "</p>");
		out.println("<P> sport2 : " + sport2 + "</p>");
		out.println("<P> note1 : " + note1 + "</p>");
		out.println("<P> note2 : " + note2 + "</p>");
		out.println("</body>");
		out.println("</html>");

	}//end of service
	
}//end of class
